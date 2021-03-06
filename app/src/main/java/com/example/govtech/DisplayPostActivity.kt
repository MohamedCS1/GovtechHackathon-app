package com.example.govtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.interfaces.SetOnClickListener

class DisplayPostActivity : AppCompatActivity() {

    var img:ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_post)

        img = findViewById(R.id.display_image)
        val bundle = intent.extras
        val image = bundle!!.getInt("image")
        img!!.setBackgroundResource(image)
    }
}