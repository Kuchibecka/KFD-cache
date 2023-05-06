package com.example.cache.model.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

@Entity
class Note(
    @Column(nullable = false, length = 255)
    var title: String,

    @Column(nullable = false, length = 1023)
    var content: String,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "page_id")
    var pages: MutableList<Page>


) : AbstractEntity()
