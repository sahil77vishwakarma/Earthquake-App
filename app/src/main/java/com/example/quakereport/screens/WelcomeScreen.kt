package com.example.quakereport.screens

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.quakereport.Authentication.LoginScreen
import com.example.quakereport.R
import com.example.quakereport.databinding.ActivityMainBinding
import com.example.quakereport.databinding.ActivityWelcomeScreenBinding

class WelcomeScreen : AppCompatActivity() {
    private val binding: ActivityWelcomeScreenBinding by lazy{
        ActivityWelcomeScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,LoginScreen::class.java))
            finish()
        },3000)


        val welcomeText = "Welcome"
        val spannableString = SpannableString(welcomeText)
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#FF0000")),0,5,0)
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#312222")),0,welcomeText.length,0)

        binding.welcomeTxt.text = spannableString

    }
}