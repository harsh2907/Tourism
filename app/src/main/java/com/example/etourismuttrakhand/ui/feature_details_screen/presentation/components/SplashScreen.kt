package com.example.etourismuttrakhand.ui.feature_details_screen.presentation.components

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.ui.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        val sharedPref = getSharedPreferences("Login",Context.MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLoggedIn",false)

        if (!isLogin) {
            Intent(this, LoginScreen::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        if(isLogin){
            Timer().apply {
                schedule(
                    timerTask {
                        startActivity(
                            Intent(this@SplashScreen,MainActivity::class.java)
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