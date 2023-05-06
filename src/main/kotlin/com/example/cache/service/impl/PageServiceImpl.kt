package com.example.cache.service.impl

import com.example.cache.model.dto.exception.ResourceNotFoundException
import com.example.cache.model.dto.request.NoteRequest
import com.example.cache.model.dto.request.PageRequest
import com.example.cache.model.entity.Page
import com.example.cache.model.repository.PageDao
import com.example.cache.service.NoteService
import com.example.cache.service.PageService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service

@Service
class PageServiceImpl(
    private val pageDao: PageDao,
    private val noteService: NoteService
) : PageService {
    override fun getNotePages(noteId: Long): Iterable<Page> = noteService.findById(noteId).pages

    override fun addNotePage(noteId: Long, request: PageRequest): Page {
        val note = noteService.findById(noteId)
        var pages = note.pages
        pages.add(request.asEntity())
        noteService.update(noteId, NoteRequest(note.title, note.content, pages))

        return request.asEntity()
    }

    @Cacheable("pages", key="#pageId")
    override fun getPage(noteId: Long, pageId: Long): Page {
        val result = noteService.findById(noteId).pages.filter { page: Page -> page.id == pageId }
        if (result.isEmpty())
            throw ResourceNotFoundException()

        return result[0]
    }

    @Modifying
    @CachePut("pages", key="#pageId")
    override fun updatePage(noteId: Long, pageId: Long, request: PageRequest): Page =
        pageDao.save(
            getPage(noteId, pageId)
                .apply { this.text = request.text }
        )

    @Modifying
    @CacheEvict("pages", key="#pageId")
    override fun deletePage(noteId: Long, pageId: Long) =
        getPage(noteId, pageId).let { pageDao.delete(it) }
}
