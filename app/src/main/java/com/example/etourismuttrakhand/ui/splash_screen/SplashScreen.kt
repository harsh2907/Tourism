package com.example.etourismuttrakhand.ui.splash_screen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.ui.MainActivity
import com.example.etourismuttrakhand.ui.login_screen.LoginScreen
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.timerTask

class SplashScreen : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        sharedPreferences = getSharedPreferences("myPreference", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        val name = sharedPreferences.getString("FirstName","")
        if(isLoggedIn){

            Timer().apply {
                schedule(
                    timerTask {
                        startActivity(
                            Intent(this@SplashScreen,MainActivity::class.java).putExtra("name",name)
                        )
                        finish()
                    },
                    2000
                )
            }
        }
        else{
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }

    }

}