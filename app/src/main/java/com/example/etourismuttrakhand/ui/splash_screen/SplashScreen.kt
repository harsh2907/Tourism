package com.example.etourismuttrakhand.ui.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.ui.MainActivity
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.timerTask

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

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

}