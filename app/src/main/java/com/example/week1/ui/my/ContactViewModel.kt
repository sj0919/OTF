package com.example.week1.ui.my

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week1.R
import com.example.week1.data.Contact

class ContactViewModel: ViewModel() {
    private val _contactList= MutableLiveData<List<Contact>>(
        listOf(
            Contact("만년닭강정-한밭야구장점", "영업시간 9:00-18:30", "123-456-7890", R.drawable.img1,isFavorite=false,stadium="한화이글스파크"),
            Contact("성심당", "영업시간 9:00-14:00", "987-654-3210",R.drawable.hanwha2,isFavorite=false,stadium="한화이글스파크"),
            Contact("신바람식당", "9:20-15:00", "555-123-4567",R.drawable.hanwha3,isFavorite=false,stadium="한화이글스파크"),
            Contact("플라잉팬","9:00-18:00","042-555-1252",R.drawable.hanwha4,isFavorite=false,stadium="한화이글스파크"),
            Contact("5.5닭갈비","9:00-14:00","042-2142-2224",R.drawable.hanwha5,isFavorite=false,stadium="한화이글스파크"),
            Contact("조마루감자탕","9:00-14:00","042-1112-2224",R.drawable.hanwha6,isFavorite=false,stadium="한화이글스파크"),
            Contact("정식당","9:00-18:00","042-1234-2224",R.drawable.hanwha7,isFavorite=false,stadium="한화이글스파크"),
            Contact("광천식당","9:00-19:00","042-2422-1234",R.drawable.hanwha8,isFavorite=false,stadium="한화이글스파크"),
            Contact("명인만두","9:00-19:00","02-2422-1234",R.drawable.hanwha8,isFavorite=false,stadium="잠실야구장"),
            Contact("통빱","9:00-19:00","02-2422-1234",R.drawable.hanwha8,isFavorite=false,stadium="잠실야구장"),
            Contact("잭슨피자","9:00-19:00","02-2422-1234",R.drawable.hanwha8,isFavorite=false,stadium="잠실야구장")

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

    val favoritesList: LiveData<List<Contact>> = MutableLiveData(
        _contactList.value?.filter { it.isFavorite }
    )

    fun toggleFavorite(contact:Contact){
        _contactList.value=_contactList.value?.map{
            if(it==contact) it.copy(isFavorite=!it.isFavorite) else it
        }
        (favoritesList as MutableLiveData).value=_contactList.value?.filter{it.isFavorite}
    }
}