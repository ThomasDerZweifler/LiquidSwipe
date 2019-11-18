package com.example.liquidswipedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jem.liquidswipe.LiquidSwipeClipPathProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager.adapter = CustomFragmentPagerAdapter(supportFragmentManager)

        /*
        // The following code can be used to dynamically change the waveCenterY
        // based on the touch position (on the LiquidSwipeViewPager).

        // The reason we don't do this internally is because,
        // sometimes the viewpager layouts don't get the touch events
        // when they are consumed directly by the viewpager.

        val liquidSwipeClipPathProviders = Array(titleArray.count()) {
            LiquidSwipeClipPathProvider()
        }

        //Similar logic can also be applied for your custom FragmentPagerAdapter
        viewpager.adapter = CustomPagerAdapter(this, liquidSwipeClipPathProviders)

        viewpager.setOnTouchListener { _, event ->
            val waveCenterY = event.y
            liquidSwipeClipPathProviders.map {
                it.waveCenterY = waveCenterY
            }
            false
        }
        */

        // Create 20 times the number of actual pages, and start in the middle.
        // This way users can swipe left or right from the start.
        // Definitely not a good idea for production, but good enough for a demo app.
        viewpager.setCurrentItem(titleArray.count() * 10, false)
    }
}
