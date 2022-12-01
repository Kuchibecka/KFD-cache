package com.example.cache.model.dto.message

import org.springframework.http.HttpStatus

class HealthMessage : AbstractApiMessage(
    status = HttpStatus.OK,
    message = "Api is working"
)