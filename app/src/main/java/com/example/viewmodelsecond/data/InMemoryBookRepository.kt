package com.example.viewmodelsecond.data

import com.example.viewmodelsecond.domain.Book
import com.example.viewmodelsecond.domain.iBookRepository

class InMemoryBookRepository : iBookRepository{


       private val books = mutableListOf<Book>()
       init {
           // Примеры книг
           books.add(Book(1, "Android Development", "John Smith"))
           books.add(Book(2, "Kotlin Basics", "JetBrains Team"))
           books.add(Book(3, "Clean Code", "Robert C. Martin"))
           books.add(Book(4, "Algorithms", "Sedgewick"))
        }
        override fun addBook(book: Book) {
            books.add(book)
        }
        override fun orderBook(book: Book) {
            book.isOrder = true
        }



        override fun findBook(title: String): Book? {
            return books.find { it.title.equals(title, ignoreCase = true) }
        }

        override fun showBook(id: Int): Book? {
            return books.find { it.id == id }
        }

}