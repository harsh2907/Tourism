package com.example.etourismuttrakhand.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.ui.feature_main_screen.MainScreen
import com.example.etourismuttrakhand.ui.feature_main_screen.MainScreenViewModel
import com.example.etourismuttrakhand.ui.login_screen.LoginScreen


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val viewModel:MainScreenViewModel by viewModels()
        val name = intent.getStringExtra("name")


        viewModel.updateUserName(name ?: "")

//        val fragInfo = MainScreen()
//        fragInfo.arguments = bundle
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_container,fragInfo)
//            commit()
//
//        }




    }
}