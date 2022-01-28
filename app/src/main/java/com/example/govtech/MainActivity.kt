package com.example.govtech

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.Pojo.Post
import com.example.fragments.*
import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener


class MainActivity : AppCompatActivity() {

    var bubbleNav:BubbleNavigationLinearView? = null
    var postsarray:ArrayList<Post>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bubbleNav = findViewById(R.id.bottom_navigation_view_linear)

        load_posts_home()

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragmentContainerView ,HomeFragment(postsarray!!))
        ft.commit()

        bubbleNav!!.setNavigationChangeListener(object :BubbleNavigationChangeListener{
            override fun onNavigationChanged(view: View?, position: Int) {
                val fmi = supportFragmentManager
                val fti = fmi.beginTransaction()
                when(position)
                {
                    0 -> {
                        load_posts_home()
                        fti.replace(R.id.fragmentContainerView ,HomeFragment(postsarray!!))
                        fti.commit()
                    }
                    1 -> {
                        load_posts_org()
                        fti.replace(R.id.fragmentContainerView ,OrganisateurFragment(postsarray!!))
                        fti.commit()
                    }
                    2 -> {
                        fti.replace(R.id.fragmentContainerView ,ChatFragment())
                        fti.commit()
                    }
                    3 -> {
                        fti.replace(R.id.fragmentContainerView ,SettingsFragment())
                        fti.commit()
                    }
                    4 -> {
                        fti.replace(R.id.fragmentContainerView ,ProfileFragment(postsarray!!))
                        fti.commit()
                    }
                }
            }

        })

    }

    fun load_posts_home()
    {
        val temp_array = arrayListOf<Post>()
        temp_array.add(Post(R.drawable.user5_photo ,"MohamedCS" ,"club scientifique esi" ,R.drawable.post1 ,"173,234 Likes" ,"is finally here \uD83D\uDE0D ✨ \uD83D\uDD25" ,R.drawable.user5_photo))
        temp_array.add(Post(R.drawable.user4_photo ,"Ahmed Dbahi" ,"club scientifique esi" ,R.drawable.post2 ,"10,234 Likes" ,"Registrations is open \uD83D\uDD25 \uD83D\uDD25 ✨" ,R.drawable.user4_photo))
        temp_array.add(Post(R.drawable.user2_photo,"Ramy" ,"club scientifique esi" ,R.drawable.post3 ,"14,654 Likes" ,"Esi ,Ouad smar \uD83D\uDCCD" , R.drawable.user2_photo))
        temp_array.add(Post(R.drawable.user2_photo ,"Anis Boras" ,"club scientifique esi" ,R.drawable.post4 ,"20,764 Likes" ,"March 17th,2022 \uD83D\uDCC5" ,R.drawable.user2_photo))
        temp_array.add(Post(R.drawable.user1_photo ,"Kamlelia" ,"club scientifique esi" ,R.drawable.post5 ,"10,659 Likes" ,"Agenda \uD83D\uDCC6" ,R.drawable.user1_photo))
        this.postsarray = temp_array
    }


    fun load_posts_org()
    {
        val temp_array = arrayListOf<Post>()
        temp_array.add(Post(R.drawable.wissal_photo ,"Wissal" ,"Présidente" ,R.drawable.post1 ,"132,534 Likes" ,"is finally here \uD83D\uDE0D ✨ \uD83D\uDD25" ,R.drawable.wissal_photo))
        temp_array.add(Post(R.drawable.akram_photo,"Akram" ,"Human Ressources manager \n ex Multimedia manager" ,R.drawable.post2 ,"10,234 Likes" ,"Registrations is open \uD83D\uDD25 \uD83D\uDD25 ✨" , R.drawable.akram_photo))
        temp_array.add(Post(R.drawable.rym_photo,"Rym" ,"Human ressources assistant" ,R.drawable.post3 ,"14,654 Likes" ,"Esi ,Ouad smar \uD83D\uDCCD" , R.drawable.seifo_photo))
        temp_array.add(Post(R.drawable.seifo_photo ,"Seifoo" ,"VP" ,R.drawable.post4 ,"20,764 Likes" ,"March 17th,2022 \uD83D\uDCC5" ,R.drawable.user2_photo))
        temp_array.add(Post(R.drawable.nasir ,"Aladdin" ,"VP" ,R.drawable.post5 ,"10,659 Likes" ,"Agenda \uD83D\uDCC6" ,R.drawable.nasir))
        this.postsarray = temp_array
    }
}