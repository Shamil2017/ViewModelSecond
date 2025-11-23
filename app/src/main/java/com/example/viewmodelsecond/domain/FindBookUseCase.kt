package com.example.viewmodelsecond.domain

class FindBookUseCase(private val repository: iBookRepository) {
    fun execute(title: String): Book? {
        return repository.findBook(title)
    }
}