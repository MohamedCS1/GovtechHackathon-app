package com.example.govtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Post
import com.example.adapters.PostSavedAdapter
import com.example.interfaces.SetOnClickListener

class AllPostSavedActivity : AppCompatActivity() {

    var rv_all_posts:RecyclerView? = null
    var postsarray:ArrayList<Post>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_post_saved)

        rv_all_posts = findViewById(R.id.rv_all_posts)

        load_posts()

        val adapter = PostSavedAdapter(this)
        val lm = GridLayoutManager(this ,2)
        rv_all_posts!!.layoutManager = lm
        rv_all_posts!!.adapter = adapter
        adapter.setList(postsarray!!)
        adapter.set_click_listener(object : SetOnClickListener {
            override fun OnPostClick(img: Int) {
                val intent = Intent(this@AllPostSavedActivity , DisplayPostActivity::class.java)
                intent.putExtra("image" ,img)
                startActivity(intent)
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