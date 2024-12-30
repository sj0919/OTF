package com.example.week1.ui.my

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.ContactsAdapter
import com.example.week1.R
import com.example.week1.databinding.FragmentMyBinding


class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoritesAdapter: ContactsAdapter
    private lateinit var viewModel: ContactViewModel


    private val imageList = arrayOf(
        R.drawable.mascot_kia,
        R.drawable.mascot_samsung,
        R.drawable.mascot_lg,
        R.drawable.mascot_doosan,
        R.drawable.mascot_ssg,
        R.drawable.mascot_kt,
        R.drawable.mascot_lotte,
        R.drawable.mascot_hanhwa,
        R.drawable.mascot_nc,
        R.drawable.mascot_kium
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ContactViewModel::class.java)

        viewModel.favoritesList.observe(viewLifecycleOwner) { favoriteContacts ->
            favoritesAdapter = ContactsAdapter(
                favoriteContacts,
                viewModel
            ) { contact ->
                // 클릭 시 수행할 작업을 정의합니다
                Log.d("MyFragment", "Contact clicked: ${contact.name}")
            }
            binding.favoritesRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = favoritesAdapter
            }
        }

//        var currentImageIndex = 0
//        // Bundle에서 currentImageIndex 받기
//        arguments?.let {
//            currentImageIndex = it.getInt("currentImageIndex", 0)
//            // 로그를 통해 값 확인
//            Log.d("MyFragment", "Received currentImageIndex: $currentImageIndex")
//        } ?: Log.d("MyFragment", "No arguments received")
//
//        // 받은 currentImageIndex로 이미지 설정
//        val imageView = binding.root.findViewById<ImageView>(R.id.userImage)
//        imageView.setImageResource(imageList[currentImageIndex])

        viewModel.currentImageIndex.observe(viewLifecycleOwner) { index ->
            val imageView = binding.root.findViewById<ImageView>(R.id.userImage)
            imageView.setImageResource(imageList[index])
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
