package com.example.govtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Pojo.Post
import com.example.fragments.ChatFragment
import com.example.fragments.HomeFragment
import com.example.fragments.OrganisateurFragment
import com.example.fragments.SettingsFragment
import com.squareup.picasso.Picasso
import io.ak1.BubbleTabBar
import io.ak1.OnBubbleClickListener

class MainActivity : AppCompatActivity() {
    var bottomtabBar:BubbleTabBar? = null
    var postsarray:ArrayList<Post>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomtabBar = findViewById(R.id.bubbleTabBar)
        bottomtabBar!!.setSelectedWithId(R.id.home)
        load_posts()
        bottomtabBar!!.addBubbleListener(object :OnBubbleClickListener{
            override fun onBubbleClick(id: Int) {
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                when(id)
                {
                    R.id.home->{
                        val homeFragment = HomeFragment(postsarray!!)
                        ft.replace(R.id.fragmentContainerView ,homeFragment)
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

    fun load_posts()
    {
        val temp_array = arrayListOf<Post>()
        temp_array.add(Post(R.drawable.user5_photo ,"MohamedCS" ,"club scientifique esi" ,R.drawable.post1 ,"173,234 Likes" ,"is finally here \uD83D\uDE0D ✨ \uD83D\uDD25" ,R.drawable.user5_photo))
        temp_array.add(Post(R.drawable.user4_photo ,"Ahmed Dbahi" ,"club scientifique esi" ,R.drawable.post2 ,"10,234 Likes" ,"Registrations is open \uD83D\uDD25 \uD83D\uDD25 ✨" ,R.drawable.user4_photo))
        temp_array.add(Post(R.drawable.user2_photo,"Ramy" ,"club scientifique esi" ,R.drawable.post3 ,"14,654 Likes" ,"Esi ,Ouad smar \uD83D\uDCCD" , R.drawable.user2_photo))
        temp_array.add(Post(R.drawable.user2_photo ,"Anis Boras" ,"club scientifique esi" ,R.drawable.post4 ,"20,764 Likes" ,"March 17th,2022 \uD83D\uDCC5" ,R.drawable.user2_photo))
        temp_array.add(Post(R.drawable.user1_photo ,"Kamlelia" ,"club scientifique esi" ,R.drawable.post5 ,"10,659 Likes" ,"Agenda \uD83D\uDCC6" ,R.drawable.user1_photo))
        this.postsarray = temp_array
    }
}