package com.example.week1

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // In-memory user data
    private val users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize test users
        initializeTestUsers()

        // Set onClickListener for the login button
        binding.btnLogin.setOnClickListener {
            val loginId = binding.etLoginId.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
               login(loginId,password)
        }
    }

    private fun initializeTestUsers() {
        users.add(User("admin", "1234"))
        users.add(User("user1", "password"))
    }

    private fun login(loginId: String, password: String) {
        if (TextUtils.isEmpty(loginId) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "로그인 정보를 입력하세요", Toast.LENGTH_SHORT).show()
            return
        }

        val user = users.find { it.loginId == loginId }

        if (user == null) {
            Toast.makeText(this, "사용자를 찾을 수 없습니다", Toast.LENGTH_SHORT).show()
        } else {
            if (user.password == password) {
                navigateToMain()
            } else {
                Toast.makeText(this, "비밀번호가 잘못되었습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        //   overridePendingTransition(0, R.anim.fade_out)
        finish()
    }
}

data class User(
    val loginId: String,
    val password: String,

)
