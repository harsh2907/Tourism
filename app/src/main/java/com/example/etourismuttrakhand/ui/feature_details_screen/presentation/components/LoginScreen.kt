package com.example.etourismuttrakhand.ui.feature_details_screen.presentation.components

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.etourismuttrakhand.databinding.ActivityLoginScreenBinding
import com.example.etourismuttrakhand.ui.MainActivity

class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.loginBtn.setOnClickListener {
            val firstName = binding.firstNameInput.text.toString().trim()
            val lastName = binding.lastNameInput.text.toString().trim()

            if(checking()){
                val name = "$firstName/$lastName"
                val sharedPref = getSharedPreferences("Login",Context.MODE_PRIVATE)
                with (sharedPref.edit()) {
                    putString("name", name)
                    putBoolean("isLoggedIn", true)
                    apply()
                }

                Intent(this, MainActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }else{
                Toast.makeText(this, "Enter Details", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun checking(): Boolean {
        return binding.firstNameInput.text.toString().trim { it <= ' ' }.isNotEmpty() &&
                binding.lastNameInput.text.toString().trim { it <= ' ' }.isNotEmpty()
    }
}