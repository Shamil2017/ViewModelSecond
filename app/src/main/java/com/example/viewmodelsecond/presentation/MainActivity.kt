package com.example.viewmodelsecond.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.viewmodelsecond.R
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

        // UI элементы
        val etTitle = findViewById<EditText>(R.id.etBookTitle)
        val etAuthor = findViewById<EditText>(R.id.etBookAuthor)
        val etId = findViewById<EditText>(R.id.etBookId)

        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnFind = findViewById<Button>(R.id.btnFind)
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnShow.setOnClickListener {

        }
        btnFind.setOnClickListener {

        }
        btnOrder.setOnClickListener {

        }
    }


}