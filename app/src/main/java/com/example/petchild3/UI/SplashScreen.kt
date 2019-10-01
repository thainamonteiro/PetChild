package com.example.petchild3.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.petchild3.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        chengeToLogin()
    }

    private fun chengeToLogin() {
        val intent = Intent(this, LoginOptions::class.java)
        Handler().postDelayed({
            intent.change()

        },2000)
    }

    fun Intent.change(){
        startActivity(this)
        finish()
    }
}
