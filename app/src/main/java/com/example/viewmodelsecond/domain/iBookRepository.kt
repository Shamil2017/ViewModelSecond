package com.example.viewmodelsecond.domain

interface iBookRepository {

        fun addBook(book: Book)
        fun orderBook(book: Book)
        fun findBook(title: String): Book?
        fun showBook(id: Int): Book?
}