package com.example.viewmodelsecond.domain

class OrderBookUseCase(private val repository: iBookRepository) {
    fun execute(book: Book) {
        repository.orderBook(book)
    }
}