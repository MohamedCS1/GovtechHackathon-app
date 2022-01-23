package com.example.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Post
import com.example.govtech.R
import com.example.interfaces.SetOnClickListener

class PostsAdapter:RecyclerView.Adapter<PostsAdapter.Holder_Post>() {

    var arrayposts = arrayListOf<Post>()

    private var listerner:SetOnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.Holder_Post {
        return Holder_Post(LayoutInflater.from(parent.context).inflate(R.layout.card_post ,parent ,false))
    }

    override fun onBindViewHolder(holder: PostsAdapter.Holder_Post, position: Int) {
        holder.display_name.text = arrayposts[position].display_name
        holder.post_views.text = arrayposts[position].post_views
        holder.post_description.text = arrayposts[position].post_description
        holder.photo_profile.setBackgroundResource(arrayposts[position].photo_profile)
        holder.post_photo.setBackgroundResource(arrayposts[position].post_photo)
        holder.post_photo_user.setBackgroundResource(arrayposts[position].photo_profile)
        holder.itemView.setOnClickListener {
            listerner!!OnPostClick(arrayposts[position].post_photo)
        }

    }

    override fun getItemCount(): Int {
        return arrayposts.size
    }

    class Holder_Post(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val photo_profile = itemView.findViewById<ImageView>(R.id.photo_profile)
        val post_photo = itemView.findViewById<ImageView>(R.id.post_photo)
        val display_name = itemView.findViewById<TextView>(R.id.display_name)
        val post_views = itemView.findViewById<TextView>(R.id.post_views)
        val post_description = itemView.findViewById<TextView>(R.id.post_description)
        val post_photo_user = itemView.findViewById<ImageView>(R.id.user_image)

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