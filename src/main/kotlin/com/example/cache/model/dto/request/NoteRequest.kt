package com.example.cache.model.dto.request

import com.example.cache.model.entity.Note

class NoteRequest(
    val title: String,
    val content: String
) {
    fun asEntity() = Note(
        title = title,
        content = content
    )
}