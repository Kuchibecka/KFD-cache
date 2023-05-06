package com.example.cache.model.dto.request

import com.example.cache.model.entity.Page

class PageRequest (
    val text: String
    ) {
    fun asEntity() = Page(
        text = text
    )
}