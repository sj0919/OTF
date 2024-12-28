package com.example.week1.ui.my

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is MyFragment"
    }
    val text: LiveData<String> = _text
}
