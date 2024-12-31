package com.example.week1.ui.notifications

import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import com.example.week1.ui.CustomInfoWindowAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
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

        // Custom InfoWindowAdapter 설정
        googleMap.setInfoWindowAdapter(CustomInfoWindowAdapter(layoutInflater))

        // 지도 초기 설정
        val hanwhaEagles = LatLng(36.3171, 127.4291) // 한화생명이글스파크
        googleMap.addMarker(
            MarkerOptions()
                .position(hanwhaEagles)
                .title("한화생명이글스파크") // 마커 제목
                .snippet("여기는 한화생명이글스파크입니다.") // 마커 설명 (InfoWindow에 표시됨)
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.red_dot_map))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val seongsimdam = LatLng(36.3276, 127.4272) // 성심당
        googleMap.addMarker(
            MarkerOptions()
                .position(seongsimdam)
                .title("성심당 본점") // 마커 제목
                .snippet("매우 혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val mannyeon = LatLng(36.3178, 127.4282) // 만년닭강정
        googleMap.addMarker(
            MarkerOptions()
                .position(mannyeon)
                .title("만년닭강정 한밭야구장점") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val sinbaramn = LatLng(36.3261, 127.4288) // 신바람식당
        googleMap.addMarker(
            MarkerOptions()
                .position(sinbaramn)
                .title("신바람식당") // 마커 제목
                .snippet("보통..") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val dakk = LatLng(36.3270, 127.4281) // 5.5닭갈비
        googleMap.addMarker(
            MarkerOptions()
                .position(dakk)
                .title("5.5닭갈비") // 마커 제목
                .snippet("보통..") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val flyingpan = LatLng(36.3274, 127.4267)
        googleMap.addMarker(
            MarkerOptions()
                .position(flyingpan)
                .title("플라잉팬") // 마커 제목
                .snippet("보통..?") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        )
        val jeong = LatLng(36.3267, 127.4257)
        googleMap.addMarker(
            MarkerOptions()
                .position(jeong)
                .title("정식당") // 마커 제목
                .snippet("보통..?") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        )
        val gwangcheon = LatLng(36.3267, 127.4257)
        googleMap.addMarker(
            MarkerOptions()
                .position(gwangcheon)
                .title("광천식당") // 마커 제목
                .snippet("보통") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val myeongin = LatLng(37.5112, 127.0728)
        googleMap.addMarker(
            MarkerOptions()
                .position(myeongin)
                .title("명인만두") // 마커 제목
                .snippet("매우혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val ttongbbab = LatLng(37.5164, 127.0729)
        googleMap.addMarker(
            MarkerOptions()
                .position(ttongbbab)
                .title("통빱") // 마커 제목
                .snippet("매우혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val oneshot = LatLng(37.5136, 127.0734)
        googleMap.addMarker(
            MarkerOptions()
                .position(oneshot)
                .title("잠실원샷") // 마커 제목
                .snippet("매우혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val jaxonpizza = LatLng(37.5113, 127.0788)
        googleMap.addMarker(
            MarkerOptions()
                .position(jaxonpizza)
                .title("잭슨피자 잠실본점") // 마커 제목
                .snippet("보통..") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val idaero = LatLng(37.2978, 127.0107)
        googleMap.addMarker(
            MarkerOptions()
                .position(idaero)
                .title("이대로통삼겹") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val gilfood = LatLng(37.2978, 127.0113)
        googleMap.addMarker(
            MarkerOptions()
                .position(gilfood)
                .title("길푸드") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val boyoung = LatLng(37.2997, 127.0091)
        googleMap.addMarker(
            MarkerOptions()
                .position(boyoung)
                .title("보영만두") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val jinmi = LatLng(37.2978, 127.0115)
        googleMap.addMarker(
            MarkerOptions()
                .position(jinmi)
                .title("진미통닭") // 마커 제목
                .snippet("매우 혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanwhaEagles, 10f)) // 줌 레벨 설정
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}