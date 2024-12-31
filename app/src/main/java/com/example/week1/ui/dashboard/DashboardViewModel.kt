package com.example.week1.ui.dashboard

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
    // 초기 URI 리스트 저장
    private val _imageUris = mutableListOf(
        Uri.parse("android.resource://com.example.week1/drawable/photo1"),
        Uri.parse("android.resource://com.example.week1/drawable/photo2"),
        Uri.parse("android.resource://com.example.week1/drawable/photo3"),
        Uri.parse("android.resource://com.example.week1/drawable/photo4"),
        Uri.parse("android.resource://com.example.week1/drawable/photo5"),
        Uri.parse("android.resource://com.example.week1/drawable/photo6"),
        Uri.parse("android.resource://com.example.week1/drawable/photo7"),
        Uri.parse("android.resource://com.example.week1/drawable/photo8")
    )

    // 이미지 URI 리스트 LiveData로 노출
    val imageUris: LiveData<List<Uri>> = MutableLiveData(_imageUris)

    // 티켓 수를 LiveData로 관리
    private val _ticketCount = MutableLiveData(_imageUris.size)
    val ticketCount: LiveData<Int> = _ticketCount

    fun addImage(uri: Uri) {
        _imageUris.add(uri)
        _ticketCount.value = _imageUris.size // 이미지가 추가될 때마다 티켓 수 업데이트
        (imageUris as MutableLiveData).value = _imageUris // 이미지 리스트 갱신
    }
}
