package measures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.quakereport.R

class MeasuresFragment : Fragment() {

    private lateinit var viewPager: ViewPager2

    private val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        // Add more image resources here
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_measures, container, false)
//        Survival tips screen
        val viewSurvival = inflater.inflate(R.layout.survival_tips_contents, container, false)

        viewPager = view.findViewById(R.id.imageSliderViewPager)

        val adapter = ImageSliderAdapter(images, viewPager)
        viewPager.adapter = adapter

        // Set auto-slide timer (adjust the delay as needed)
        val autoSlideHandler = AutoSlideHandler(viewPager)
        viewPager.registerOnPageChangeCallback(autoSlideHandler)

//        on click on Card

        val survivalCard = view.findViewById<CardView>(R.id.survivalTipsCard);
        survivalCard.setOnClickListener{

        }


        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager.adapter = null
    }

}