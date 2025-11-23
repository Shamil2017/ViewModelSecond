package com.example.viewmodelsecond.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    init {
        Log.d("AAA","VM created")
    }

    override fun onCleared() {
        Log.d("AAA","VM Cleared")
        super.onCleared()
    }

}