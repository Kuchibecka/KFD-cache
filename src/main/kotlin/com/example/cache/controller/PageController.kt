package com.example.cache.controller

import com.example.cache.model.dto.ApiResponse
import com.example.cache.model.dto.message.DeletedMessage
import com.example.cache.model.dto.request.PageRequest
import com.example.cache.model.entity.Page
import com.example.cache.service.PageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notes")
class PageController(
    private val pageService: PageService
) {
    @GetMapping("/{noteId}/page")
    fun list(@PathVariable noteId: String): Iterable<Page> = pageService.getNotePages(noteId.toLong())

    @PostMapping("/{noteId}/page")
    fun create(@PathVariable noteId: String, @RequestBody request: PageRequest): Page =
        pageService.addNotePage(noteId.toLong(), request)

    @GetMapping("/{noteId}/page/{pageId}")
    fun getPage(@PathVariable noteId: String, @PathVariable pageId: String): Page =
        pageService.getPage(noteId.toLong(), pageId.toLong())

    @PutMapping("/{noteId}/page/{pageId}")
    fun updatePage(@PathVariable noteId: String, @PathVariable pageId: String, @RequestBody request: PageRequest)
    = pageService.updatePage(noteId.toLong(), pageId.toLong(), request)

    @DeleteMapping("/{noteId}/page/{pageId}")
    fun deletePage(@PathVariable noteId: String, @PathVariable pageId: String): ResponseEntity<ApiResponse>
    = pageService.deletePage(noteId.toLong(), pageId.toLong()).let { return@let DeletedMessage().asResponse() }
}
