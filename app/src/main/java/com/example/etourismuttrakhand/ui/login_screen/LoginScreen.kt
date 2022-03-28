package com.example.etourismuttrakhand.ui.login_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.databinding.ActivityLoginScreenBinding
import com.example.etourismuttrakhand.ui.MainActivity
import com.google.android.material.snackbar.Snackbar

class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.isActivated = binding.firstNameInput.text.toString().isNotBlank() &&
                binding.lastNameInput.text.toString().isNotBlank()

        binding.loginBtn.setOnClickListener {
            val first = binding.firstNameInput.text.toString()
            val last = binding.lastNameInput.text.toString()
            if (first.isNotBlank() && last.isNotBlank()) {
                val name = "$first/$last"
                startActivity(
                    Intent(this,MainActivity::class.java).putExtra("name",name)
                )

            } else if (first.isBlank() && last.isNotBlank()) {


            }
            else if(first.isNotBlank() && last.isBlank()){

            }else{

            }
        }
        }
    }
}