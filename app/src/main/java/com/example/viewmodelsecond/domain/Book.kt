package com.example.viewmodelsecond.domain

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    var isOrder: Boolean = false
)