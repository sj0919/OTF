package com.example.week1.ui.my

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week1.R
import com.example.week1.data.Contact

class ContactViewModel: ViewModel() {
    private val _contactList= MutableLiveData<List<Contact>>(
        listOf(
            //한화
            Contact("만년닭강정", "영업시간 9:00-18:30", "123-456-7890", R.drawable.img1,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("성심당", "영업시간 9:00-14:00", "987-654-3210",R.drawable.hanwha2,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("키다리 트위스트","작은메아리","크리미튀소")),
            Contact("신바람식당", "영업시간 9:20-15:00", "555-123-4567",R.drawable.hanwha3,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("김치찌개","동태찌개")),
            Contact("플라잉팬","영업시간 9:00-18:00","042-555-1252",R.drawable.hanwha4,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("5.5닭갈비","영업시간 9:00-14:00","042-2142-2224",R.drawable.hanwha5,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("조마루감자탕","영업시간9:00-14:00","042-1112-2224",R.drawable.hanwha6,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("정식당","영업시간 9:00-18:00","042-1234-2224",R.drawable.hanwha7,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("광천식당","영업시간 9:00-19:00","042-2422-1234",R.drawable.hanwha2,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("야구장왕돈까스","영업시간 9:00-19:00","042-2422-1234",R.drawable.hanwha2,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("왕돈까스")),
            Contact("오늘은족발","영업시간 9:00-19:00","042-2422-1234",R.drawable.hanwha2,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("족발","매운족발")),
            Contact("홈런친닭","영업시간 9:00-19:00","042-2422-1234",R.drawable.hanwha2,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("새우강정","닭강정")),
            //잠실
            Contact("명인만두","영업시간 9:00-19:00","02-2422-1234",R.drawable.jamsil1,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("고기만두","김치만두")),
            Contact("통빱","영업시간 9:00-19:00","02-2422-1234",R.drawable.jamsil2,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("삼겹살정식","통비빔면")),
            Contact("잠실원샷","영업시간 9:00-19:00","02-2422-1234",R.drawable.jamsil3,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("프랭크버거","영업시간 9:00-19:00","02-2422-1234",R.drawable.jamsil4,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("BHC치킨","영업시간 9:00-19:00","02-2422-1234",R.drawable.jamsil5,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("매운닭강정")),
            Contact("잭슨피자","영업시간 9:00-19:00","02-2422-1234",R.drawable.jamsil6,isFavorite=false,stadium="잠실야구장",recommendedMenu = listOf("매운닭강정","순한닭강정")),
            //수원
            Contact("이대로통삼겹","영업시간 9:00-19:00","031-2422-1234",R.drawable.kt1,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("통삼겹살")),
            Contact("길푸드","영업시간 9:00-19:00","031-2422-1234",R.drawable.kt2,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("보영만두","영업시간 9:00-19:00","031-2422-1234",R.drawable.kt3,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정", "순한닭강정")),
            Contact("진미통닭","영업시간 9:00-19:00","031-2422-1234",R.drawable.kt4,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정", "순한닭강정")),
            Contact("파파존스","영업시간 9:00-19:00","031-2422-1234",R.drawable.kt5,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정", "순한닭강정")),
            Contact("끼부리또","영업시간 9:00-19:00","031-2422-1234",R.drawable.kt6,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정", "순한닭강정")),
            //사직
            Contact("주문진 막국수","영업시간 9:00-19:00","051-2422-1234",R.drawable.busan1,isFavorite=false,stadium="사직야구장", recommendedMenu = listOf("막국수", "수육")),
            Contact("쌍둥이 돼지국밥","영업시간 9:00-19:00","051-2422-1234",R.drawable.busan2,isFavorite=false,stadium="사직야구장", recommendedMenu = listOf("돼지국밥","순대국밥")),
            Contact("33떡볶이","영업시간 9:00-19:00","051-2422-1234",R.drawable.busan3,isFavorite=false,stadium="사직야구장", recommendedMenu = listOf("떡볶이","꼬마김밥","33세트")),
            Contact("남도푸드앤","영업시간 9:00-19:00","051-2422-1234",R.drawable.busan4,isFavorite=false,stadium="사직야구장", recommendedMenu = listOf("버터먹태","거인의 세트")),
            Contact("정직유부초밥","영업시간 9:00-19:00","051-2422-1234",R.drawable.busan5,isFavorite=false,stadium="사직야구장", recommendedMenu = listOf("정직유부,참치마요유부")),
            Contact("닭터케이 닭꼬치","영업시간 9:00-19:00","051-2422-1234",R.drawable.busan6,isFavorite=false,stadium="사직야구장", recommendedMenu = listOf("그냥닭","양념닭")),
            //문학
            Contact("스테이션","영업시간 9:00-19:00","032-2422-1234",R.drawable.ssg1,isFavorite=false,stadium="인천SSG랜더스필드", recommendedMenu = listOf("크림새우")),
            Contact("허갈닭강정","영업시간 9:00-19:00","032-2422-1234",R.drawable.ssg2,isFavorite=false,stadium="인천SSG랜더스필드", recommendedMenu = listOf("닭강정 허브달콤맛")),
            Contact("북촌손만두","영업시간 9:00-19:00","032-2422-1234",R.drawable.ssg3,isFavorite=false,stadium="인천SSG랜더스필드", recommendedMenu = listOf("피냉면")),
            Contact("킹콩떡볶이","영업시간 9:00-19:00","032-2422-1234",R.drawable.ssg4,isFavorite=false,stadium="인천SSG랜더스필드", recommendedMenu = listOf("킹콩국물떡볶이","쿵쿵튀김")),
            Contact("시빌라핫도그","영업시간 9:00-19:00","032-2422-1234",R.drawable.ssg5,isFavorite=false,stadium="인천SSG랜더스필드", recommendedMenu = listOf("소시지","또띠아")),
            //대구
            Contact("땅땅치킨","영업시간 11:00-19:00","053-1424-1623",R.drawable.samsung1,isFavorite=false,stadium="대구삼성라이온즈파크", recommendedMenu = listOf("소시지","또띠아")),
            Contact("5직떡볶이","영업시간 12:00-19:00","053-7623-1262",R.drawable.samsung2,isFavorite=false,stadium="대구삼성라이온즈파크", recommendedMenu = listOf("소시지","또띠아")),
            Contact("한만두","영업시간 16:00-19:00","053-6467-6856",R.drawable.samsung3,isFavorite=false,stadium="대구삼성라이온즈파크", recommendedMenu = listOf("갈비만두","짬뽕만두")),
            Contact("족발슈퍼","영업시간 16:00-19:00","053-2422-9898",R.drawable.samsung4,isFavorite=false,stadium="대구삼성라이온즈파크", recommendedMenu = listOf("순살족발","소떡소떡")),
            Contact("블루팡팡","영업시간 11:00-19:00","053-1253-3463",R.drawable.samsung5,isFavorite=false,stadium="대구삼성라이온즈파크", recommendedMenu = listOf("구슬아이스크림")),
            Contact("전설꼬치","영업시간 12:00-19:00","053-6755-9866",R.drawable.samsung6,isFavorite=false,stadium="대구삼성라이온즈파크", recommendedMenu = listOf("닭살꼬치","파닭꼬치")),
            //고척
            Contact("감탄계","영업시간 11:00-19:00","02-1422-5344",R.drawable.ki1,isFavorite=false,stadium="고척스카이돔", recommendedMenu = listOf("숯불양념구이")),
            Contact("감자아이스크림","영업시간 12:00-19:00","02-2322-8658",R.drawable.ki2,isFavorite=false,stadium="고척스카이돔", recommendedMenu = listOf("감자아이스크림")),
            Contact("오토김밥","영업시간 10:00-19:00","02-0344-9575",R.drawable.ki3,isFavorite=false,stadium="고척스카이돔", recommendedMenu = listOf("오토김밥","오토 닭강정 콤비")),
            Contact("백남옥손만두","영업시간 14:00-19:00","02-1534-4855",R.drawable.ki4,isFavorite=false,stadium="고척스카이돔", recommendedMenu = listOf("고기통만두","김치통만두")),
            Contact("쉬림프쉐프","영업시간 12:00-19:00","02-5533-1623",R.drawable.ki5,isFavorite=false,stadium="고척스카이돔", recommendedMenu = listOf("소시지","또띠아")),
            //NC
            Contact("제일버거","영업시간 11:00-19:00","055-2422-1634",R.drawable.nc1,isFavorite=false,stadium="창원NC파크", recommendedMenu = listOf("제일버거, NC다이노소세지")),
            Contact("싸움의고수","영업시간 10:00-19:00","055-1342-6234",R.drawable.nc2,isFavorite=false,stadium="창원NC파크", recommendedMenu = listOf("싸움족발","마늘족발")),
            Contact("알통 떡강정","영업시간 9:00-19:00","055-1635-1674",R.drawable.nc3,isFavorite=false,stadium="창원NC파크", recommendedMenu = listOf("알통떡강정")),
            Contact("죠스떡볶이","영업시간 9:00-19:00","055-2263-6434",R.drawable.nc4,isFavorite=false,stadium="창원NC파크", recommendedMenu = listOf("떡볶이","수제튀김")),
            Contact("리얼피그","영업시간 10:00-19:00","055-2453-1531",R.drawable.nc5,isFavorite=false,stadium="창원NC파크", recommendedMenu = listOf("NC대세닭")),
            Contact("스트릿츄러스","영업시간 9:00-19:00","055-2422-7754",R.drawable.nc6,isFavorite=false,stadium="창원NC파크", recommendedMenu = listOf("아이스크림츄로볼")),
            //광주
            Contact("인크커피","영업시간 10:00-22:00","0507-1363-5941",R.drawable.kia1,isFavorite=false,stadium="광주기아챔피언스필드", recommendedMenu = listOf("불고기독","미트칠리독")),
            Contact("양동시장 치킨","영업시간 7:00-23:30","062-364-5410",R.drawable.kia2,isFavorite=false,stadium="광주기아챔피언스필드", recommendedMenu = listOf("후라이드닭강정")),
            Contact("스테이션","영업시간 9:00-19:00","062-2422-1234",R.drawable.kia3,isFavorite=false,stadium="광주기아챔피언스필드", recommendedMenu = listOf("크림새우")),
            Contact("짝태패밀리","영업시간 9:00-19:00","062-2422-1234",R.drawable.kia4,isFavorite=false,stadium="광주기아챔피언스필드", recommendedMenu = listOf("오징어")),
            Contact("시골집","영업시간 9:00-19:00","062-2422-1234",R.drawable.kia5,isFavorite=false,stadium="광주기아챔피언스필드", recommendedMenu = listOf("애호박찌개")),

            )
    )
    val stadiumList=listOf("한화이글스파크","사직야구장","잠실야구장","수원KT위즈파크","인천SSG랜더스필드","대구삼성라이온즈파크","고척스카이돔","창원NC파크","광주기아챔피언스필드")
    private val _filteredContacts=MutableLiveData<List<Contact>>()
    val filteredContacts:LiveData<List<Contact>>get()=_filteredContacts
    fun filterContactsByStadium(stadium:String){
        _filteredContacts.value=_contactList.value?.filter{it.stadium==stadium}
    }
    val contactList: LiveData<List<Contact>>
        get()=_contactList

    private val _favoritesList = MutableLiveData<List<Contact>>()
    val favoritesList: LiveData<List<Contact>> get() = _favoritesList

    private val _favoritesCount=MutableLiveData<Int>()
    val favoritesCount:LiveData<Int>get()=_favoritesCount

    init {
        // 초기화 시 favoritesList를 contactList에서 가져옴
        updateFavoritesList()
    }

    fun toggleFavorite(contact: Contact) {
        // contactList를 업데이트
        _contactList.value = _contactList.value?.map {
            if (it == contact) it.copy(isFavorite = !it.isFavorite) else it
        }

        // 모든 종속 LiveData를 갱신
        updateFilteredContacts()
        updateFavoritesList()
    }

    private fun updateFilteredContacts() {
        val currentStadiumFilter = _filteredContacts.value?.firstOrNull()?.stadium
        _filteredContacts.value = if (currentStadiumFilter != null) {
            _contactList.value?.filter { it.stadium == currentStadiumFilter }
        } else {
            _contactList.value
        }
    }

    private fun updateFavoritesList() {
        _favoritesList.value = _contactList.value?.filter { it.isFavorite }
        updateFavoritesCount()
    }
    private fun updateFavoritesCount(){
        _favoritesCount.value=_favoritesList.value?.size?:0
    }

    val currentImageIndex = MutableLiveData<Int>()

}