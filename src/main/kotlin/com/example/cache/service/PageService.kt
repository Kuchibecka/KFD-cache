package com.example.cache.service

import com.example.cache.model.dto.request.PageRequest
import com.example.cache.model.entity.Page
import org.springframework.stereotype.Service

@Service
interface PageService {
    fun getNotePages(noteId: Long): Iterable<Page>
    fun addNotePage(noteId: Long, request: PageRequest): Page
    fun getPage(noteId: Long, pageId: Long): Page
    fun updatePage(noteId: Long, pageId: Long, request: PageRequest): Page
    fun deletePage(noteId: Long, pageId: Long)
}