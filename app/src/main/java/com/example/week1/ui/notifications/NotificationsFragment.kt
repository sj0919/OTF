package com.example.week1.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.week1.R
import com.example.week1.databinding.FragmentNotificationsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class NotificationsFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 액션바 숨기기
        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        // SupportMapFragment 초기화
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this) // 지도 준비 콜백 설정
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // 지도 초기 설정
        val hanwhaEagles = LatLng(36.3171, 127.4291) // 서울 좌표
        googleMap.addMarker(MarkerOptions().position(hanwhaEagles).title("한화이글스파크ㅁ"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanwhaEagles, 16f)) // 줌 레벨 설정
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}