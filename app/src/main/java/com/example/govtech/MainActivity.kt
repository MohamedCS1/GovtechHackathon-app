package com.example.govtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments.ChatFragment
import com.example.fragments.HomeFragment
import com.example.fragments.OrganisateurFragment
import com.example.fragments.SettingsFragment
import io.ak1.BubbleTabBar
import io.ak1.OnBubbleClickListener

class MainActivity : AppCompatActivity() {
    var bottomtabBar:BubbleTabBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomtabBar = findViewById(R.id.bubbleTabBar)

        bottomtabBar!!.addBubbleListener(object :OnBubbleClickListener{
            override fun onBubbleClick(id: Int) {
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                when(id)
                {
                    R.id.home->{
                        ft.replace(R.id.fragmentContainerView ,HomeFragment())
                        ft.commit()
                    }
                    R.id.org ->{
                        ft.replace(R.id.fragmentContainerView ,OrganisateurFragment())
                        ft.commit()
                    }
                    R.id.chat->{
                        ft.replace(R.id.fragmentContainerView ,ChatFragment())
                        ft.commit()
                    }
                    R.id.settings->{
                        ft.replace(R.id.fragmentContainerView ,SettingsFragment())
                        ft.commit()
                    }
                }
            }

        })
    }
}