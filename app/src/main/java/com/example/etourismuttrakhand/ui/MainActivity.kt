package com.example.etourismuttrakhand.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.ui.feature_main_screen.MainScreen
import com.example.etourismuttrakhand.ui.login_screen.LoginScreen


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val name = intent.getStringExtra("name")


        val bundle = Bundle().apply {
            putString("name",name)
        }

//        val fragInfo = MainScreen()
//        fragInfo.arguments = bundle
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_container,fragInfo)
//            commit()
//
//        }




    }
}