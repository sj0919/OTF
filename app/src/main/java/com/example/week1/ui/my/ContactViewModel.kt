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
            Contact("만년닭강정", "영업시간 9:00-18:30", "123-456-7890", R.drawable.img1,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("성심당", "영업시간 9:00-14:00", "987-654-3210",R.drawable.hanwha2,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("키다리 트위스트","작은메아리","크리미튀소")),
            Contact("신바람식당", "9:20-15:00", "555-123-4567",R.drawable.hanwha3,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("김치찌개","동태찌개")),
            Contact("플라잉팬","9:00-18:00","042-555-1252",R.drawable.hanwha4,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("5.5닭갈비","9:00-14:00","042-2142-2224",R.drawable.hanwha5,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("조마루감자탕","9:00-14:00","042-1112-2224",R.drawable.hanwha6,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("정식당","9:00-18:00","042-1234-2224",R.drawable.hanwha7,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("광천식당","9:00-19:00","042-2422-1234",R.drawable.hanwha2,isFavorite=false,stadium="한화이글스파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("명인만두","9:00-19:00","02-2422-1234",R.drawable.jamsil1,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("고기만두","김치만두")),
            Contact("통빱","9:00-19:00","02-2422-1234",R.drawable.jamsil2,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("삼겹살정식","통비빔면")),
            Contact("잠실원샷","9:00-19:00","02-2422-1234",R.drawable.jamsil3,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("프랭크버거","9:00-19:00","02-2422-1234",R.drawable.jamsil4,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("BHC치킨","9:00-19:00","02-2422-1234",R.drawable.jamsil5,isFavorite=false,stadium="잠실야구장", recommendedMenu = listOf("매운닭강정")),
            Contact("잭슨피자","9:00-19:00","02-2422-1234",R.drawable.jamsil6,isFavorite=false,stadium="잠실야구장",recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("이대로통삼겹","9:00-19:00","031-2422-1234",R.drawable.kt1,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("통삼겹살")),
            Contact("길푸드","9:00-19:00","031-2422-1234",R.drawable.kt2,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정","순한닭강정")),
            Contact("보영만두","9:00-19:00","031-2422-1234",R.drawable.kt3,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정", "순한닭강정")),
            Contact("진미통닭","9:00-19:00","031-2422-1234",R.drawable.kt4,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정", "순한닭강정")),
            Contact("파파존스","9:00-19:00","031-2422-1234",R.drawable.kt5,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정", "순한닭강정")),
            Contact("끼부리또","9:00-19:00","031-2422-1234",R.drawable.kt6,isFavorite=false,stadium="수원KT위즈파크", recommendedMenu = listOf("매운닭강정", "순한닭강정"))
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

//    val favoritesList: LiveData<List<Contact>> = MutableLiveData(
//        _contactList.value?.filter { it.isFavorite }
//    )
    private val _favoritesList = MutableLiveData<List<Contact>>()
    val favoritesList: LiveData<List<Contact>> get() = _favoritesList

    init {
        // 초기화 시 favoritesList를 contactList에서 가져옴
        updateFavoritesList()
    }

//    private val _favoritesList = MutableLiveData<List<Contact>>(emptyList())
//        val favoritesList: LiveData<List<Contact>> get() = _favoritesList

//    fun toggleFavorite(contact:Contact) {
//        _filteredContacts.value = _filteredContacts.value?.map {
//            if (it == contact) it.copy(isFavorite = !it.isFavorite) else it
//        }
//        (favoritesList as MutableLiveData).value=_filteredContacts.value?.filter{it.isFavorite}
//    }
    fun toggleFavorite(contact: Contact) {
        // contactList를 업데이트
        _contactList.value = _contactList.value?.map {
            if (it == contact) it.copy(isFavorite = !it.isFavorite) else it
        }

        // 모든 종속 LiveData를 갱신
        updateFilteredContacts()
        updateFavoritesList()
    }

//    private fun updateFilteredContacts() {
//        _filteredContacts.value = _filteredContacts.value?.let { currentFiltered ->
//            _contactList.value?.filter { currentFiltered.contains(it) }
//        } ?: _contactList.value
//    }
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
    }

    val currentImageIndex = MutableLiveData<Int>()

}