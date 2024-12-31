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
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.R
import com.example.week1.databinding.FragmentDashboardBinding
import com.example.week1.databinding.FragmentMyBinding

class DashboardFragment : Fragment() {

    private lateinit var imageAdapter: ImageAdapter
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DashboardViewModel

    private val selectImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                viewModel.addImage(uri) // ViewModel에 추가
                updateRecyclerView()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java) // ViewModel 초기화

        // RecyclerView 설정
        imageAdapter = ImageAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = imageAdapter
        }

        updateRecyclerView()

        // 버튼 클릭 시 갤러리에서 이미지 선택
        binding.buttonSelectImage.setOnClickListener {
            selectImageLauncher.launch("image/*")
        }

        return binding.root
    }

    private fun updateRecyclerView() {
        imageAdapter.setImages(viewModel.imageUris) // ViewModel 데이터로 RecyclerView 업데이트
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

