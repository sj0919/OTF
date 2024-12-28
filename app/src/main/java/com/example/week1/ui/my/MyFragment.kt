package com.example.week1.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.ContactsAdapter
import com.example.week1.R
import com.example.week1.databinding.FragmentMyBinding
import com.example.week1.data.Contact

class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoritesAdapter:ContactsAdapter
    private lateinit var viewModel:ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentMyBinding.inflate(inflater,container,false)
        viewModel=ViewModelProvider(requireActivity()).get(ContactViewModel::class.java)

        viewModel.favoritesList.observe(viewLifecycleOwner){favoriteContacts->favoritesAdapter=ContactsAdapter(favoriteContacts,viewModel)
        binding.favoritesRecyclerView.apply{
            layoutManager=LinearLayoutManager(context)
            adapter=favoritesAdapter
        }}
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}