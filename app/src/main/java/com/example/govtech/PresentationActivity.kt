package com.example.govtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.Adapters.SliderAdapter
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class PresentationActivity : AppCompatActivity() {

    var sliderview:SliderView? = null
    var slideradapter:SliderAdapter? = null
    var bu_skip:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)

        bu_skip = findViewById(R.id.bu_skip)

        sliderview = findViewById(R.id.slider_view)

        val arrayOfImages = arrayOf(R.drawable.background_about ,R.drawable.background_aboute1)

        slideradapter = SliderAdapter(arrayOfImages)

        sliderview!!.setSliderAdapter(slideradapter!!)

        sliderview!!.setIndicatorAnimation(IndicatorAnimationType.WORM)

        sliderview!!.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)

        bu_skip!!.setOnClickListener {
            startActivity(Intent(this ,LoginActivity::class.java))
        }

    }

}