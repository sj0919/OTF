package com.example.week1

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.databinding.ActivityNewBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class NewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewBinding

    // 갤러리에서 선택된 이미지를 처리하는 ActivityResultLauncher 설정
    private val selectImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                // 이미지 URI로부터 Bitmap을 얻어 ImageView에 설정
                binding.imageView3.setImageURI(it)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ImageButton 클릭 시 갤러리 앱 실행
        binding.imageButton.setOnClickListener {
            // 갤러리에서 이미지를 선택하도록 요청
            selectImageLauncher.launch("image/*")
        }
    }

    // 뒤로 가기 버튼 클릭 시 처리
    fun onGoBackClicked(view: View) {
        finish() // 액티비티 종료
    }
}
