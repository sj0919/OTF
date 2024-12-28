package com.example.week1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.R
import com.example.week1.data.Contact
import com.example.week1.databinding.FragmentHomeBinding
import com.example.week1.ContactsAdapter
import com.example.week1.ui.my.ContactViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var viewModel:ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel= ViewModelProvider(requireActivity()).get(ContactViewModel::class.java)

        viewModel.contactList.observe(viewLifecycleOwner){contactList->contactsAdapter=ContactsAdapter(contactList,viewModel)
        binding.contactsRecyclerView.apply{
            layoutManager=LinearLayoutManager(context)
            adapter=contactsAdapter
        }}
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
