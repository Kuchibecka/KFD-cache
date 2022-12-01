package com.example.cache.model.dto.exception

import org.springframework.http.HttpStatus

class ResourceNotFoundException : AbstractApiException(
    status = HttpStatus.NOT_FOUND,
    message = "Resource not found"
)