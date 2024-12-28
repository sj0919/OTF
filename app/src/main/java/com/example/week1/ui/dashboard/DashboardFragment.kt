package com.example.week1.ui.dashboard

import ImageAdapter
import SharedViewModel
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.R
import com.example.week1.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var imageAdapter: ImageAdapter
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    // 갤러리에서 이미지를 선택하는 ActivityResultLauncher
    private val selectImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                // 선택된 이미지를 RecyclerView에 표시할 수 있도록 URI 리스트에 추가
                imageAdapter.addImage(uri)
            }
        }

    private val initialImageUris = listOf(
        Uri.parse("android.resource://com.example.week1/drawable/tticket1"),
        Uri.parse("android.resource://com.example.week1/drawable/tticket2"),
        Uri.parse("android.resource://com.example.week1/drawable/tticket3"),
        Uri.parse("android.resource://com.example.week1/drawable/ticket4"),
        Uri.parse("android.resource://com.example.week1/drawable/ticket5"),
        Uri.parse("android.resource://com.example.week1/drawable/ticket6")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        // RecyclerView 설정
        imageAdapter = ImageAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = imageAdapter
        }

        // 미리 준비된 이미지를 어댑터에 추가
        imageAdapter.setImages(initialImageUris)

        // 버튼 클릭 시 갤러리에서 이미지 선택
        binding.buttonSelectImage.setOnClickListener {
            selectImageLauncher.launch("image/*")
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}