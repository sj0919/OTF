package com.example.week1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val name: String,
    val time: String,
    val phoneNumber: String,
    val image: Int,
    val isFavorite: Boolean = false,
    val stadium: String
) : Parcelable
