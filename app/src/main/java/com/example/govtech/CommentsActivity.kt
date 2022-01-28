package com.example.govtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.tools.CircleTransform
import com.squareup.picasso.Picasso

class CommentsActivity : AppCompatActivity() {

    var bu_back:ImageView? = null
    var coment_photo:ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        bu_back = findViewById(R.id.bu_back)
        coment_photo = findViewById(R.id.comment_photo1)

        bu_back!!.setOnClickListener {
            onBackPressed()
        }

        Picasso.with(this).load(R.drawable.user5_photo).transform(CircleTransform()).into(coment_photo)

    }
}