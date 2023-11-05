package com.example.quakereport.measures

import androidx.viewpager2.widget.ViewPager2

class AutoSlideHandler(private val viewPager: ViewPager2) : ViewPager2.OnPageChangeCallback() {
    private val slideDelay = 3000L // Adjust the delay as needed
    private val runnable = Runnable {
        val currentItem = viewPager.currentItem
        viewPager.setCurrentItem(if (currentItem + 1 < (viewPager.adapter?.itemCount ?: 0)) currentItem + 1 else 0, true)
    }

    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        viewPager.postDelayed(runnable, slideDelay)
    }
}
