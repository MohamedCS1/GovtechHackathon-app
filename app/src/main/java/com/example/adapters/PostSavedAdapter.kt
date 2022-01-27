package com.example.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Post
import com.example.govtech.R
import com.example.interfaces.SetOnClickListener
import com.example.tools.RoundedTransformation
import com.squareup.picasso.Picasso


class PostSavedAdapter(val context: Context): RecyclerView.Adapter<PostSavedAdapter.Holder_Post>() {

    var arrayposts = arrayListOf<Post>()

    private var listerner: SetOnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostSavedAdapter.Holder_Post {
        return Holder_Post(LayoutInflater.from(parent.context).inflate(R.layout.card_post_saved ,parent ,false))
    }
    override fun getItemCount(): Int {
        return arrayposts.size
    }

    override fun onBindViewHolder(holder: Holder_Post, position: Int) {
        Picasso.with(context).load(arrayposts[position].post_photo).transform(
            RoundedTransformation(90 ,0)
        ).into(holder.post_saved_photo)

        holder.post_saved_photo.setOnClickListener {
            listerner!!OnPostClick(arrayposts[position].post_photo)
        }
    }

    class Holder_Post(itemView:View): RecyclerView.ViewHolder(itemView)
    { 
        val post_saved_photo = itemView.findViewById<ImageView>(R.id.image_posts_saved)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(ArrayOfPosts:ArrayList<Post>)
    {
        this.arrayposts = ArrayOfPosts
        notifyDataSetChanged()
    }

    fun set_click_listener(Listener: SetOnClickListener)
    {
        this.listerner = Listener
    }


}