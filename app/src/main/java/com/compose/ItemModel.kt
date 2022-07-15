package com.compose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemModel(
    val title: String,
    val description: String,
    val imageUrl: String
) : Parcelable