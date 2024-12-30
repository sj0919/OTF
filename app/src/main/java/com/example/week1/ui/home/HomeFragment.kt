package com.example.week1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.ContactsAdapter
import com.example.week1.databinding.FragmentHomeBinding
import com.example.week1.ui.my.ContactViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var viewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ContactViewModel::class.java]

        contactsAdapter = ContactsAdapter(emptyList(), viewModel) { contact ->
            val dialog = ContactDetailsDialogFragment.newInstance(contact)
            dialog.show(parentFragmentManager, "ContactDetailsDialog")
        }

        binding.contactsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = contactsAdapter
        }


        // 설정: Spinner (드롭다운 메뉴)
        val stadiumAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            viewModel.stadiumList
        )
        binding.spinnerBaseballStadium.adapter = stadiumAdapter

        viewModel.contactList.observe(viewLifecycleOwner) { contacts ->
            contactsAdapter.updateContacts(contacts)
        }

        viewModel.filteredContacts.observe(viewLifecycleOwner) { contacts ->
            contactsAdapter.updateContacts(contacts)
        }
        // Spinner 선택 시 데이터 필터링
        binding.spinnerBaseballStadium.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedStadium = viewModel.stadiumList[position]
                viewModel.filterContactsByStadium(selectedStadium)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 아무것도 선택되지 않았을 경우 처리 (필요 시 구현)
            }
        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 액션바 숨기기
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
