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
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mascot_hanhwa))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
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
        val somoon = LatLng(35.1959, 129.0596)
        googleMap.addMarker(
            MarkerOptions()
                .position(somoon)
                .title("소문난 주문진 막국수") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val twinspig = LatLng(35.1975, 129.0652)
        googleMap.addMarker(
            MarkerOptions()
                .position(twinspig)
                .title("쌍둥이돼지국밥") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val namdofood = LatLng(35.1939, 129.0596)
        googleMap.addMarker(
            MarkerOptions()
                .position(namdofood)
                .title("남도푸드") // 마커 제목
                .snippet("매우 혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val doctorK = LatLng(35.1932, 129.0610)
        googleMap.addMarker(
            MarkerOptions()
                .position(doctorK)
                .title("닭터케이 사직야구장점") // 마커 제목
                .snippet("매우 혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val station = LatLng(37.4368, 126.6926)
        googleMap.addMarker(
            MarkerOptions()
                .position(station)
                .title("스테이션") // 마커 제목
                .snippet("매우 혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val heogal = LatLng(37.4371, 126.6924)
        googleMap.addMarker(
            MarkerOptions()
                .position(heogal)
                .title("허갈닭강정") // 마커 제목
                .snippet("매우 혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val kingkong = LatLng(37.4377, 126.6932)
        googleMap.addMarker(
            MarkerOptions()
                .position(kingkong)
                .title("킹콩떡볶이") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val ddangddang = LatLng(35.8411, 128.6812)
        googleMap.addMarker(
            MarkerOptions()
                .position(ddangddang)
                .title("땅땅치킨") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val ohjik = LatLng(35.8404, 128.6812)
        googleMap.addMarker(
            MarkerOptions()
                .position(ohjik)
                .title("5직떡볶이") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val jokbalsuper = LatLng(35.8403, 128.6806)
        googleMap.addMarker(
            MarkerOptions()
                .position(jokbalsuper)
                .title("족발슈퍼") // 마커 제목
                .snippet("보통..?") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        )
        val gamtan = LatLng(37.4980, 126.8664)
        googleMap.addMarker(
            MarkerOptions()
                .position(gamtan)
                .title("감탄계") // 마커 제목
                .snippet("보통..") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val otto = LatLng(37.5002, 126.8670)
        googleMap.addMarker(
            MarkerOptions()
                .position(otto)
                .title("오토김밥") // 마커 제목
                .snippet("보통..") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val dalin = LatLng( 37.4998, 126.8670)
        googleMap.addMarker(
            MarkerOptions()
                .position(dalin)
                .title("백남옥달인손만두") // 마커 제목
                .snippet("보통..") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val jeil = LatLng( 35.2219, 128.5795)
        googleMap.addMarker(
            MarkerOptions()
                .position(jeil)
                .title("제일버거") // 마커 제목
                .snippet("보통..") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val realpig = LatLng( 35.2229, 128.5815)
        googleMap.addMarker(
            MarkerOptions()
                .position(realpig)
                .title("리얼피그") // 마커 제목
                .snippet("보통..") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        )
        val rtong = LatLng( 35.2235, 128.5817)
        googleMap.addMarker(
            MarkerOptions()
                .position(rtong)
                .title("알통떡강정") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val inc = LatLng( 35.1675, 126.8891)
        googleMap.addMarker(
            MarkerOptions()
                .position(inc)
                .title("인크커피") // 마커 제목
                .snippet("매우 혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        val jjaktae = LatLng( 35.1687, 126.8883)
        googleMap.addMarker(
            MarkerOptions()
                .position(jjaktae)
                .title("짝태패밀리") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val yangdong = LatLng( 35.1536, 126.9007)
        googleMap.addMarker(
            MarkerOptions()
                .position(yangdong)
                .title("양동시장치킨") // 마커 제목
                .snippet("혼잡!!") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        )
        val ssg = LatLng( 37.4369, 126.6932)
        googleMap.addMarker(
            MarkerOptions()
                .position(ssg)
                .title("인천랜더스필드") // 마커 제목
                .snippet("여기는 SSG랜더스필드입니다.") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )
        val jamsil = LatLng( 37.5120, 127.0718)
        googleMap.addMarker(
            MarkerOptions()
                .position(jamsil)
                .title("잠실야구장") // 마커 제목
                .snippet("여기는 잠실야구장입니다.") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )
        val champions = LatLng( 35.1681, 126.8891)
        googleMap.addMarker(
            MarkerOptions()
                .position(champions)
                .title("광주기아챔피언스필드") // 마커 제목
                .snippet("여기는 광주기아챔피언스필드입니다.") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )
        val skydome = LatLng( 37.4982, 126.8670)
        googleMap.addMarker(
            MarkerOptions()
                .position(skydome)
                .title("고척스카이돔") // 마커 제목
                .snippet("여기는 고척스카이돔입니다.") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )
        val wizpark = LatLng( 37.2997, 127.0097)
        googleMap.addMarker(
            MarkerOptions()
                .position(wizpark)
                .title("KT위즈파크") // 마커 제목
                .snippet("여기는 KT위즈파크입니다.") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )
        //nc, 삼성, 롯데
        val changwon = LatLng( 35.2228, 128.5819)
        googleMap.addMarker(
            MarkerOptions()
                .position(changwon)
                .title("창원NC파크") // 마커 제목
                .snippet("여기는 창원NC파크입니다.") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )
        val lionspark = LatLng( 35.8410, 128.6816)
        googleMap.addMarker(
            MarkerOptions()
                .position(lionspark)
                .title("대구삼성라이온즈파크") // 마커 제목
                .snippet("여기는 대구삼성라이온즈파크입니다.") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )
        val sajik = LatLng( 35.1940, 129.0615)
        googleMap.addMarker(
            MarkerOptions()
                .position(sajik)
                .title("부산사직야구장") // 마커 제목
                .snippet("여기는 부산사직야구장입니다.") // 마커 설명 (InfoWindow에 표시됨)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanwhaEagles, 10f)) // 줌 레벨 설정
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}