package com.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var count by mutableStateOf(0)
    var items by mutableStateOf(listOf<ItemModel>())

    fun addItem() {
        count++
        items = items + ItemModel(
            title = "Item Title $count",
            description = "Item Description",
            imageUrl = "https://picsum.photos/${100 + count}"
        )
    }

}