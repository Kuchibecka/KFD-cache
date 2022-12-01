package com.example.cache.model.dto.message

import com.example.cache.model.dto.ApiResponse
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

abstract class AbstractApiMessage(
    override val status: HttpStatus,
    override val message: String
) : ApiResponse {
    override val timestamp: LocalDateTime = LocalDateTime.now()
}