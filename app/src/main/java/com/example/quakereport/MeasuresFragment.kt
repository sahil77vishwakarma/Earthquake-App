package com.example.quakereport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MeasuresFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_measures)

        val cardView = findViewById<CardView>(R.id.survivalTipsCard)

        cardView.setOnClickListener {
            print("Hello sir")
        }
    }
}
