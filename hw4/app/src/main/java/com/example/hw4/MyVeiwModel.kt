package com.example.hw4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyVeiwModel : ViewModel() {
    var count = 0
    var countLivedata: MutableLiveData<Int> = MutableLiveData<Int>()
    init {
        countLivedata.value = 0
    }
    fun increaseCount() {
        countLivedata.value = (countLivedata.value ?: 0) + 1
    }
    fun decreaseCount() {
        countLivedata.value = (countLivedata.value ?: 0) - 1
    }
}
