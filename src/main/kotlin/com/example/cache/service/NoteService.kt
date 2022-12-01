package com.example.cache.service

import com.example.cache.model.dto.request.NoteRequest
import com.example.cache.model.entity.Note

interface NoteService {
    fun list(): Iterable<Note>
    fun create(request: NoteRequest): Note
    fun findById(id: Long): Note
    fun update(id: Long, request: NoteRequest): Note
    fun delete(id: Long)
}