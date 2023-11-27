package com.example.quakereport.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.quakereport.R

class AccountScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Handling the back button to navigate back to SurvivalToolsContents
        val bckBut = findViewById<ImageView>(R.id.accountBackButton)
        bckBut.setOnClickListener {
            finish()
        }

    }
}