package com.example.viewmodelsecond.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelsecond.data.InMemoryBookRepository
import com.example.viewmodelsecond.domain.FindBookUseCase
import com.example.viewmodelsecond.domain.OrderBookUseCase
import com.example.viewmodelsecond.domain.ShowBookUseCase

class MainViewModel:ViewModel() {

    private val repository = InMemoryBookRepository()

    private val findBookUseCase = FindBookUseCase(repository)
    private val orderBookUseCase = OrderBookUseCase(repository)
    private val showBookUseCase = ShowBookUseCase(repository)

    val resultLiveData = MutableLiveData<String>()

    init {
        Log.d("AAA","VM created")
    }

    override fun onCleared() {
        Log.d("AAA","VM Cleared")
        super.onCleared()
    }
    fun showBook(id: Int) {
        Log.d("AAA","showBook")
        val book = showBookUseCase.execute(id)
        if (book == null) {
            Log.d("AAA","Книга не найдена")
            resultLiveData.value = "Книга не найдена"
        } else {
            Log.d("AAA","Книга найдена")
            resultLiveData.value =
                "Книга:\nID: ${book.id}\n${book.title} — ${book.author}\nЗаказана: ${book.isOrder}"
        }
    }

    fun findBook(title: String) {
        val book = findBookUseCase.execute(title)
        if (book == null) {
            resultLiveData.value = "Книга не найдена"
        } else {
            resultLiveData.value =
                "Найдена книга:\nID: ${book.id}\n${book.title} — ${book.author}\nЗаказана: ${book.isOrder}"
        }
    }

    fun orderBook(id: Int) {
        val book = showBookUseCase.execute(id)
        if (book == null) {
            resultLiveData.value = "Книга не найдена"
        } else {
            orderBookUseCase.execute(book)
            resultLiveData.value =
                "Книга заказана:\nID: ${book.id}\n${book.title} — ${book.author}"
        }
    }

}