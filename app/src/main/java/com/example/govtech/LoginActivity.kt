package com.example.govtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    var bu_skip:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bu_skip = findViewById(R.id.bu_loginskip)

        bu_skip!!.setOnClickListener {
            startActivity(Intent(this ,MainActivity::class.java))
        }
    }
}