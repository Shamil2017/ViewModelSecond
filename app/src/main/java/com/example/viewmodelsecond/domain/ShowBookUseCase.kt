package com.example.viewmodelsecond.domain

class ShowBookUseCase(private val repository: iBookRepository) {
    fun execute(id: Int): Book? {
        return repository.showBook(id)
    }
}