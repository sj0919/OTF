package com.example.week1.ui

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.week1.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class CustomInfoWindowAdapter(private val layoutInflater: LayoutInflater) : GoogleMap.InfoWindowAdapter {

    override fun getInfoWindow(marker: Marker): View? {
        // 기본 InfoWindow 스타일을 유지하고 싶을 경우 null 반환
        return null
    }

    override fun getInfoContents(marker: Marker): View {
        // 커스텀 레이아웃 설정
        val view = layoutInflater.inflate(R.layout.custom_info_window, null)

        val titleTextView = view.findViewById<TextView>(R.id.title)
        val snippetTextView = view.findViewById<TextView>(R.id.snippet)

        titleTextView.text = marker.title
        snippetTextView.text = marker.snippet

        return view
    }
}
