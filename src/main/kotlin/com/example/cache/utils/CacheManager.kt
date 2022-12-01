package com.example.cache.utils

import com.google.common.cache.CacheBuilder
import org.slf4j.LoggerFactory
import org.springframework.cache.Cache
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.concurrent.ConcurrentMapCacheManager
import java.util.concurrent.TimeUnit

class CacheManager : ConcurrentMapCacheManager() {
    private val logger = LoggerFactory.getLogger(CacheManager::class.java)

    override fun createConcurrentMapCache(name: String): Cache {
        val builder = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build<Any, Any>().asMap()
        return ConcurrentMapCache(name, builder, true)
    }

    override fun getCache(name: String) = super.getCache(name).also { logger.info("Reading cache ${it?.name}") }
}