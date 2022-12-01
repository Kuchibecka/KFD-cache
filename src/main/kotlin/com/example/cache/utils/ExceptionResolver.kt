package com.example.cache.utils

import com.example.cache.model.dto.ApiResponse
import com.example.cache.model.dto.exception.AbstractApiException
import com.example.cache.model.dto.exception.InternalServerException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ExceptionResolver {
    private val logger = LoggerFactory.getLogger(ExceptionResolver::class.java)

    @ExceptionHandler(value = [AbstractApiException::class])
    protected fun handle(cause: AbstractApiException, request: WebRequest): ResponseEntity<ApiResponse> {
        logger.info(cause.stackTraceToString())
        return cause.asResponse()
    }

    @ExceptionHandler(value = [Throwable::class])
    protected fun handle(cause: Throwable, request: WebRequest): ResponseEntity<ApiResponse> {
        logger.error(cause.stackTraceToString())
        return InternalServerException().asResponse()
    }
}