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
    private var _dashboardBinding: FragmentDashboardBinding? = null
    private val dashboardBinding get() = _dashboardBinding!!

    private var _myBinding: FragmentMyBinding? = null
    private val myBinding get() = _myBinding!!

    private var ticketCount:Int=0

    // 갤러리에서 이미지를 선택하는 ActivityResultLauncher
    private val selectImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                // 선택된 이미지를 RecyclerView에 표시할 수 있도록 URI 리스트에 추가
                imageAdapter.addImage(uri)
                updateTicketCount()
            }
        }

    private val initialImageUris = listOf(
        Uri.parse("android.resource://com.example.week1/drawable/photo1"),
        Uri.parse("android.resource://com.example.week1/drawable/photo2"),
        Uri.parse("android.resource://com.example.week1/drawable/photo3"),
        Uri.parse("android.resource://com.example.week1/drawable/photo4"),
        Uri.parse("android.resource://com.example.week1/drawable/photo5"),
        Uri.parse("android.resource://com.example.week1/drawable/photo6"),
        Uri.parse("android.resource://com.example.week1/drawable/photo7"),
        Uri.parse("android.resource://com.example.week1/drawable/photo8")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _dashboardBinding= FragmentDashboardBinding.inflate(inflater, container, false)
        _myBinding=FragmentMyBinding.inflate(inflater,container,false)

        // RecyclerView 설정
        imageAdapter = ImageAdapter()
        dashboardBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = imageAdapter
        }

        // 미리 준비된 이미지를 어댑터에 추가
        imageAdapter.setImages(initialImageUris)
        updateTicketCount()

        // 버튼 클릭 시 갤러리에서 이미지 선택
        dashboardBinding.buttonSelectImage.setOnClickListener {
            selectImageLauncher.launch("image/*")
        }
        setupRecyclerView()
        return dashboardBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 액션바 숨기기
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
    }

    private fun setupRecyclerView(){
        imageAdapter=ImageAdapter()
        dashboardBinding.recyclerView.apply{
            layoutManager=LinearLayoutManager(requireContext())
            adapter=imageAdapter
        }
        imageAdapter.setImages(initialImageUris)
    }
    private fun updateTicketCount(){
        ticketCount=imageAdapter.itemCount
        myBinding.ticketCountTextView.text="티켓수 $ticketCount"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _dashboardBinding = null
        _myBinding=null
    }
}