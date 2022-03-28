package com.example.etourismuttrakhand.ui.login_screen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.databinding.ActivityLoginScreenBinding
import com.example.etourismuttrakhand.ui.feature_main_screen.MainScreen
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        login_btn.setOnClickListener {
            val firstName = firstNameInput.text.toString().trim()
            val lastName = lastNameInput.text.toString().trim()
            sharedPref = getSharedPreferences("myPreference", Context.MODE_PRIVATE)

            if(checking()){
                val name = "$firstName/$lastName"
                sharedPref.edit().putString("FirstName", name).apply()
                sharedPref.edit().putBoolean("isLoggedIn", true).apply()
                startActivity(Intent(this, MainScreen::class.java))
            }else{
                Toast.makeText(this, "Enter Details", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun checking(): Boolean {
        return firstNameInput.text.toString().trim { it <= ' ' }.isNotEmpty() &&
                lastNameInput.text.toString().trim { it <= ' ' }.isNotEmpty()
    }
}