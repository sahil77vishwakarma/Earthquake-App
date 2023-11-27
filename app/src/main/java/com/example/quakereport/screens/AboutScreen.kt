package com.example.quakereport.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.quakereport.R

class AboutScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Handling the back button to navigate back to SurvivalToolsContents
        val bckBut = findViewById<ImageView>(R.id.aboutBackButton)
        bckBut.setOnClickListener {
            finish()
        }

    }
}