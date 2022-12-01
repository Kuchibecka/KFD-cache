package com.example.cache.controller

import com.example.cache.model.dto.message.HealthMessage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CommonController {
    @GetMapping("/health")
    fun healthcheck() = HealthMessage().asResponse()
}