package com.example.cache.model.dto.exception

import org.springframework.http.HttpStatus

class InternalServerException : AbstractApiException(
    status = HttpStatus.INTERNAL_SERVER_ERROR,
    message = "Something went wrong"
)