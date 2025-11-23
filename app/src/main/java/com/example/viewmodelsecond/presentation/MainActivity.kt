package com.example.viewmodelsecond.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelsecond.R
import com.example.viewmodelsecond.data.InMemoryBookRepository
import com.example.viewmodelsecond.domain.FindBookUseCase
import com.example.viewmodelsecond.domain.OrderBookUseCase
import com.example.viewmodelsecond.domain.ShowBookUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d("AAA","Activity created")

        vm = ViewModelProvider(this).get(MainViewModel::class.java)


        // UI элементы
        val etTitle = findViewById<EditText>(R.id.etBookTitle)
        val etAuthor = findViewById<EditText>(R.id.etBookAuthor)
        val etId = findViewById<EditText>(R.id.etBookId)

        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnFind = findViewById<Button>(R.id.btnFind)
        val btnOrder = findViewById<Button>(R.id.btnOrder)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        vm.resultLiveData.observe(this) { text ->
            tvResult.text = text
        }

        // кнопка Показать книгу
        btnShow.setOnClickListener {
            val id = etId.text.toString().toIntOrNull()
            if (id == null) {
                tvResult.text = "Введите ID книги"
            } else {
                vm.showBook(id)
            }
        }

        // кнопка Найти книгу
        btnFind.setOnClickListener {
            val title = etTitle.text.toString()
            if (title.isBlank()) {
                tvResult.text = "Введите название книги"
            } else {
                vm.findBook(title)
            }
        }

        // кнопка Заказать книгу
        btnOrder.setOnClickListener {
            val id = etId.text.toString().toIntOrNull()
            if (id == null) {
                tvResult.text = "Введите ID книги"
            } else {
                vm.orderBook(id)
            }
        }
    }


}