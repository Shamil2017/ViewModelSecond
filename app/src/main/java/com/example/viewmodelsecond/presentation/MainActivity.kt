package com.example.viewmodelsecond.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.viewmodelsecond.R
import com.example.viewmodelsecond.data.InMemoryBookRepository
import com.example.viewmodelsecond.domain.FindBookUseCase
import com.example.viewmodelsecond.domain.OrderBookUseCase
import com.example.viewmodelsecond.domain.ShowBookUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var findBookUseCase: FindBookUseCase
    private lateinit var orderBookUseCase: OrderBookUseCase
    private lateinit var showBookUseCase: ShowBookUseCase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Создаём репозиторий с тестовыми книгами
        val repository = InMemoryBookRepository()

        // ИНИЦИАЛИЗАЦИЯ USE CASE-ОВ
        findBookUseCase = FindBookUseCase(repository)
        orderBookUseCase = OrderBookUseCase(repository)
        showBookUseCase = ShowBookUseCase(repository)

        // UI элементы
        val etTitle = findViewById<EditText>(R.id.etBookTitle)
        val etAuthor = findViewById<EditText>(R.id.etBookAuthor)
        val etId = findViewById<EditText>(R.id.etBookId)

        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnFind = findViewById<Button>(R.id.btnFind)
        val btnOrder = findViewById<Button>(R.id.btnOrder)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnShow.setOnClickListener {
            val id = etId.text.toString().toIntOrNull()
            if (id == null || title.isBlank() ) {
                tvResult.text = "Введите id книги"
                return@setOnClickListener
            }
            val book = showBookUseCase.execute(id)
            if (book == null) {
                tvResult.text = "Книга не найдена"
            } else {
                tvResult.text = "Найдена книга:\nID: ${book.id}\n${book.title} — ${book.author}"
            }

        }
        btnFind.setOnClickListener {
            val title = etTitle.text.toString()

            if (title.isBlank()) {
                tvResult.text = "Введите название книги"
                return@setOnClickListener
            }

            val book = findBookUseCase.execute(title)

            if (book == null) {
                tvResult.text = "Книга не найдена"
            } else {
                tvResult.text = "Найдена книга:\nID: ${book.id}\n${book.title} — ${book.author}"
            }
        }
        btnOrder.setOnClickListener {
            val id = etId.text.toString().toIntOrNull()
            if (id == null || title.isBlank() ) {
                tvResult.text = "Введите id книги"
                return@setOnClickListener
            }
            val book = showBookUseCase.execute(id)
            if (book == null) {
                tvResult.text = "Книга не найдена"
            } else {
                orderBookUseCase.execute(book)
                tvResult.text = "Заказана книга:\nID: ${book.id}\n${book.title} — ${book.author}"

            }
        }
    }


}