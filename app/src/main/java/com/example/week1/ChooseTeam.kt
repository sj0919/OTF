package com.example.week1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.ui.my.ContactViewModel

class ChooseTeam : AppCompatActivity() {

    private var currentImageIndex = 0
    private val imageList = arrayOf(
        R.drawable.team_kia,
        R.drawable.team_samsung,
        R.drawable.team_lg,
        R.drawable.team_doosan,
        R.drawable.team_ssg,
        R.drawable.team_kt,
        R.drawable.team_lotte,
        R.drawable.team_hanwha,
        R.drawable.team_nc,
        R.drawable.team_kium
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooseteam)

        // 액션바 숨기기
        supportActionBar?.hide()

        val imageView = findViewById<ImageView>(R.id.imageView)
        val nextButton = findViewById<Button>(R.id.next_button)
        val prevButton = findViewById<Button>(R.id.prev_button)
        val selectButton = findViewById<Button>(R.id.select_button)

        // Restore saved instance state
        savedInstanceState?.let {
            currentImageIndex = it.getInt("currentImageIndex", 0)
        }
        imageView.setImageResource(imageList[currentImageIndex])
        // Next button functionality
        nextButton.setOnClickListener {
            currentImageIndex = (currentImageIndex + 1) % imageList.size
            updateImage(imageView)
        }

        // Previous button functionality
        prevButton.setOnClickListener {
            currentImageIndex = if (currentImageIndex - 1 < 0) imageList.size - 1 else currentImageIndex - 1
            updateImage(imageView)
        }

        // Select button functionality
        selectButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // currentImageIndex를 Intent에 추가
            intent.putExtra("currentImageIndex", currentImageIndex)
            startActivity(intent)
        }
    }

    private fun updateImage(imageView: ImageView) {
        currentImageIndex = if (currentImageIndex < 0) 0 else currentImageIndex % imageList.size
        imageView.setImageResource(imageList[currentImageIndex])
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentImageIndex", currentImageIndex)
    }

}
