package com.example.week1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.R
import com.example.week1.data.Contact
import com.example.week1.databinding.FragmentHomeBinding
import com.example.week1.ContactsAdapter


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var contactsAdapter: ContactsAdapter
    private val contactList = listOf(
        Contact("만년닭강정-한밭야구장점", "영업시간 9:00-18:30", "123-456-7890", R.drawable.img1),
        Contact("성심당", "영업시간 9:00-14:00", "987-654-3210",R.drawable.img1),
        Contact("신바람식당", "9:20-15:00", "555-123-4567",R.drawable.img1),
        Contact("플라잉팬","9:00-18:00","042-555-1252",R.drawable.img1),
        Contact("정식당","9:00-14:00","042-2142-2224",R.drawable.img1),
        Contact("5.5닭갈비","9:00-14:00","042-1112-2224",R.drawable.img1),
        Contact("조마루감자탕","9:00-18:00","042-1234-2224",R.drawable.img1),
        Contact("광천식당","9:00-19:00","042-2422-1234",R.drawable.img1)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // RecyclerView 설정
        contactsAdapter = ContactsAdapter(contactList)
        binding.contactsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = contactsAdapter
        }
        // 액션바 다시 표시
        (activity as? AppCompatActivity)?.supportActionBar?.show()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
