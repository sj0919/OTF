package com.example.week1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ChooseTeam : AppCompatActivity() {

    private var currentImageIndex = 0
    private val imageList = arrayOf(
        R.drawable.team_hanhwa,  // 실제 이미지 리소스 파일로 교체
        R.drawable.team_lg,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooseteam)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val changeImageButton = findViewById<Button>(R.id.next_button)

        // 초기 이미지 설정
        imageView.setImageResource(imageList[currentImageIndex])

        // 버튼 클릭 리스너 설정
        changeImageButton.setOnClickListener {
            // 인덱스를 증가시켜서 다음 이미지를 표시
            currentImageIndex = (currentImageIndex + 1) % imageList.size
            imageView.setImageResource(imageList[currentImageIndex])
        }
        val selectButton = findViewById<Button>(R.id.select_button)
        selectButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
