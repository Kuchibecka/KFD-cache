package com.example.cache.service.impl

import com.example.cache.model.dto.exception.ResourceNotFoundException
import com.example.cache.model.dto.request.NoteRequest
import com.example.cache.model.entity.Note
import com.example.cache.model.repository.NoteDao
import com.example.cache.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.ApplicationContext
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service

@Service
class NoteServiceImpl(
    private val noteDao: NoteDao
) : NoteService {

    override fun list(): Iterable<Note> = noteDao.findAll()

    override fun create(request: NoteRequest): Note {
        val note = request.asEntity()
        return noteDao.save(note)
    }

    @Cacheable("notes", key = "#id")
    override fun findById(id: Long): Note = noteDao.findById(id).orElseThrow { ResourceNotFoundException() }

    @Modifying
    @CachePut("notes", key = "#id")
    override fun update(id: Long, request: NoteRequest): Note = findById(id).apply {
        content = request.content
        title = request.title
        noteDao.save(this)
    }

    @Modifying
    @CacheEvict("notes", key = "#id")
    override fun delete(id: Long) {
        if (!noteDao.existsById(id)) throw ResourceNotFoundException()
        noteDao.deleteById(id)
    }
}