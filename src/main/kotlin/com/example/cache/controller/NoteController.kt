package com.example.cache.controller

import com.example.cache.model.dto.ApiResponse
import com.example.cache.model.dto.message.DeletedMessage
import com.example.cache.model.dto.request.NoteRequest
import com.example.cache.model.entity.Note
import com.example.cache.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class NoteController(
    private val noteService: NoteService
) {
    @GetMapping("/notes")
    fun list(): Iterable<Note> = noteService.list()

    @PostMapping("/notes")
    @ResponseStatus(value=HttpStatus.CREATED)
    fun create(@RequestBody request: NoteRequest): Note = noteService.create(request)

    @GetMapping("/notes/{id}")
    fun findById(@PathVariable id: Long): Note = noteService.findById(id)

    @PutMapping("/notes/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: NoteRequest): Note = noteService.update(id, request)

    @DeleteMapping("/notes/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<ApiResponse> {
        noteService.delete(id)
        return DeletedMessage().asResponse()
    }
}
