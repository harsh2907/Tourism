package com.example.etourismuttrakhand.ui.login_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.isActivated = !binding.firstNameInput.text.toString().isBlank() && !binding.lastNameInput.text.toString().isBlank()
    }
}