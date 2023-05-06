package com.example.cache.model.dto.request

import com.example.cache.model.entity.Note
import com.example.cache.model.entity.Page

class NoteRequest(
    val title: String,
    val content: String,
    val pages: MutableList<Page>
) {
    fun asEntity() = Note(
        title = title,
        content = content,
        pages = pages
    )
}