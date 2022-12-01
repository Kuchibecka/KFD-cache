package com.example.cache.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Note(
    @Column(nullable = false, length = 255)
    var title: String,

    @Column(nullable = false, length = 1023)
    var content: String
) : AbstractEntity()
