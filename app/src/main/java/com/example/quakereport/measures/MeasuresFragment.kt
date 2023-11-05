package com.example.quakereport.measures

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.quakereport.R
import com.example.quakereport.screens.SurvivalToolsContents

class MeasuresFragment : Fragment() {

    private lateinit var viewPager: ViewPager2

    private val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        // Add more image resources here
    )

    private lateinit var mainLayout: RelativeLayout
    private lateinit var survivalTipsLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_measures, container, false)

        // Initialize layouts
        mainLayout = view.findViewById(R.id.layout_measures_parentView)
        survivalTipsLayout = view.findViewById(R.id.survivalTipsLayout_childView)

        ///HANDLING THE IMAGE SLIDER
        viewPager = view.findViewById(R.id.imageSliderViewPager)
        val adapter = ImageSliderAdapter(images, viewPager)
        viewPager.adapter = adapter
        // Set auto-slide timer (adjust the delay as needed)
        val autoSlideHandler = AutoSlideHandler(viewPager)
        viewPager.registerOnPageChangeCallback(autoSlideHandler)

        ///HANDLING THE LAYOUT SWITCH
        val survivalTipsCard = mainLayout.findViewById<CardView>(R.id.survivalTipsCard)
        survivalTipsCard.setOnClickListener {
            toggleLayouts()
        }

        val childLayoutBackButton = survivalTipsLayout.findViewById<ImageView>(R.id.backButton)
        childLayoutBackButton.setOnClickListener{
            toggleLayouts()
        }


        ///HANDLING CLICK FOR TOOL SECTION(CARD)
        val survivalToolCard = mainLayout.findViewById<CardView>(R.id.survivalToolsCard)
        survivalToolCard.setOnClickListener {
            val intent = Intent(requireContext(), SurvivalToolsContents::class.java)
            startActivity(intent)
        }

        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        viewPager.adapter = null
    }

    private fun toggleLayouts() {
        if (mainLayout.visibility == View.VISIBLE) {
            mainLayout.visibility = View.GONE
            survivalTipsLayout.visibility = View.VISIBLE
        } else {
            mainLayout.visibility = View.VISIBLE
            survivalTipsLayout.visibility = View.GONE
        }
    }
}