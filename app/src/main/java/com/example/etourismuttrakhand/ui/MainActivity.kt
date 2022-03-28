package com.example.etourismuttrakhand.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.ui.login_screen.LoginScreen
import kotlinx.android.synthetic.main.fragment_main_screen.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val name = intent.getStringExtra("name")
        val first = name?.substringBefore('/') ?:""
        val last = name?.substringAfter('/') ?: ""




    }
}