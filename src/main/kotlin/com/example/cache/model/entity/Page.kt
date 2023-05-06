package com.example.cache.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Page (
    @Column(nullable = false, length = 1023)
    var text: String
): AbstractEntity()