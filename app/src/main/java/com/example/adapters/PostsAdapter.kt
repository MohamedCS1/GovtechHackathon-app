package com.example.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.Pojo.Post
import com.example.govtech.CommentsActivity
import com.example.govtech.R
import com.example.interfaces.SetOnClickListener
import com.squareup.picasso.Picasso
import com.example.tools.CircleTransform
import com.example.tools.RoundedTransformation
import com.bumptech.glide.request.RequestOptions





class PostsAdapter(val context:Context):RecyclerView.Adapter<PostsAdapter.Holder_Post>() {

    var arrayposts = arrayListOf<Post>()

    var array_position = -1

    private var listerner:SetOnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.Holder_Post {
        return Holder_Post(LayoutInflater.from(parent.context).inflate(R.layout.card_post ,parent ,false))
    }

    @SuppressLint("CheckResult")
    override fun onViewAttachedToWindow(holder: Holder_Post) {
        val requestOptions = RequestOptions()
        requestOptions.transform(RoundedCorners(70))
        Glide.with(context).load(arrayposts[array_position].photo_profile).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.post_photo)
        Glide.with(context).load(arrayposts[array_position].post_photo).apply(requestOptions).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.post_photo)
        Glide.with(context).load(arrayposts[array_position].photo_profile).circleCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.photo_profile)
        Glide.with(context).load(arrayposts[array_position].photo_profile).circleCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.post_photo_user)

//        Picasso.with(context).load(arrayposts[array_position].photo_profile).transform(CircleTransform()).into(holder.post_photo)
//        Picasso.with(context).load(arrayposts[array_position].post_photo).transform(RoundedTransformation(90,90)).into(holder.post_photo)
//        Picasso.with(context).load(arrayposts[array_position].photo_profile).transform(CircleTransform()).into(holder.photo_profile)
//        Picasso.with(context).load(arrayposts[array_position].photo_profile).transform(CircleTransform()).into(holder.post_photo_user)
        super.onViewAttachedToWindow(holder)
    }

    override fun onBindViewHolder(holder: PostsAdapter.Holder_Post, position: Int) {
        array_position = position
        holder.display_name.text = arrayposts[position].display_name
        holder.post_views.text = arrayposts[position].post_views
        holder.post_description.text = arrayposts[position].post_description
        holder.post_location.text = arrayposts[position].post_location


        holder.post_photo.setOnClickListener {
            listerner!!OnPostClick(arrayposts[position].post_photo)
        }

        var isSaved:Boolean = false
        holder.bookmark.setOnClickListener {
            if (!isSaved)
            {
                holder.bookmark.setImageDrawable(getDrawable(context,R.drawable.ic_book_mark_saved))
                Toast.makeText(context,"saved", Toast.LENGTH_SHORT).show()
                isSaved = true
            }
            else
            {
                holder.bookmark.setImageDrawable(getDrawable(context,R.drawable.ic_bookmark))
                Toast.makeText(context,"Save has been cancelled",Toast.LENGTH_SHORT).show()
                isSaved = false
            }

        }

        var isLiked:Boolean = false
        holder.like.setOnClickListener {
            if (!isLiked)
            {
                holder.like.setImageDrawable(getDrawable(context,R.drawable.ic_like_active))
                isLiked = true
            }
            else
            {
                holder.like.setImageDrawable(getDrawable(context,R.drawable.ic_like_active))
                isLiked = false
            }

        }

        holder.messege.setOnClickListener {
            context.startActivities(arrayOf(Intent(context ,CommentsActivity::class.java)))
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
        val post_location = itemView.findViewById<TextView>(R.id.post_location)
        val bookmark = itemView.findViewById<ImageView>(R.id.bookmark)
        val like = itemView.findViewById<ImageView>(R.id.like)
        val messege = itemView.findViewById<ImageView>(R.id.message)

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