package com.example.cache.model.repository

import com.example.cache.model.entity.Note
import org.springframework.data.repository.CrudRepository

interface NoteDao : CrudRepository<Note, Long>