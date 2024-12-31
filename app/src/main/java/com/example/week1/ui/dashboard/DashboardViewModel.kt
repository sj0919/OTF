package com.example.week1.ui.dashboard

import android.net.Uri
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
    // 초기 URI 리스트 저장
    val imageUris = mutableListOf(
        Uri.parse("android.resource://com.example.week1/drawable/photo1"),
        Uri.parse("android.resource://com.example.week1/drawable/photo2"),
        Uri.parse("android.resource://com.example.week1/drawable/photo3"),
        Uri.parse("android.resource://com.example.week1/drawable/photo4"),
        Uri.parse("android.resource://com.example.week1/drawable/photo5"),
        Uri.parse("android.resource://com.example.week1/drawable/photo6"),
        Uri.parse("android.resource://com.example.week1/drawable/photo7"),
        Uri.parse("android.resource://com.example.week1/drawable/photo8")
    )


    fun addImage(uri: Uri) {
        imageUris.add(uri)
    }
}
