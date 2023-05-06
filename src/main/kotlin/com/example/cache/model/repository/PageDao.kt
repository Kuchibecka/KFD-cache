package com.example.cache.model.repository

import com.example.cache.model.entity.Page
import org.springframework.data.repository.CrudRepository

interface PageDao: CrudRepository<Page, Long>