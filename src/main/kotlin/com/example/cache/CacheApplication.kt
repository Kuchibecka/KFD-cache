package com.example.cache

import com.example.cache.utils.CacheManager
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class CacheApplication

@Configuration
@EnableCaching
class CacheConfig {
    @Bean
    fun cacheManager() = CacheManager()
}

fun main(args: Array<String>) {
    runApplication<CacheApplication>(*args)
}
