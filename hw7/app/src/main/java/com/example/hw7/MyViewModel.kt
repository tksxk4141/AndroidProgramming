package com.example.hw7

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Item(val name: String, val phone: String)

class MyViewModel : ViewModel() {
    val items = ArrayList<Item>()
    val itemsLiveData = MutableLiveData<ArrayList<Item>>()

    var longClickItem: Int = -1

    init{
        addItem(Item("james","010-1234-5678"))
        addItem(Item("tom","010-9876-5432"))
    }

    fun addItem(item:Item){
        items.add(item)
        itemsLiveData.value=items
    }

    fun updateItem(item:Item,pos: Int){
        items[pos]=item
        itemsLiveData.value=items
    }

    fun deleteItem(pos: Int){
        items.removeAt(pos)
        itemsLiveData.value=items
    }
}