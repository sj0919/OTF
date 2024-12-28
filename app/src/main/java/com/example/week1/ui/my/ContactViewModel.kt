package com.example.week1.ui.my

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week1.R
import com.example.week1.data.Contact

class ContactViewModel: ViewModel() {
    private val _contactList= MutableLiveData<List<Contact>>(
        listOf(
            Contact("만년닭강정-한밭야구장점", "영업시간 9:00-18:30", "123-456-7890", R.drawable.img1,isFavorite=false),
            Contact("성심당", "영업시간 9:00-14:00", "987-654-3210",R.drawable.img1,isFavorite=false),
            Contact("신바람식당", "9:20-15:00", "555-123-4567",R.drawable.img1,isFavorite=false),
            Contact("플라잉팬","9:00-18:00","042-555-1252",R.drawable.img1,isFavorite=false),
            Contact("정식당","9:00-14:00","042-2142-2224",R.drawable.img1,isFavorite=false),
            Contact("5.5닭갈비","9:00-14:00","042-1112-2224",R.drawable.img1,isFavorite=false),
            Contact("조마루감자탕","9:00-18:00","042-1234-2224",R.drawable.img1,isFavorite=false),
            Contact("광천식당","9:00-19:00","042-2422-1234",R.drawable.img1,isFavorite=false)
        )
    )
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