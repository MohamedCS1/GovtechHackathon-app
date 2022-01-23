package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Adapters.PostsAdapter
import com.example.Pojo.Post
import com.example.govtech.Display_Post
import com.example.govtech.R
import com.example.interfaces.SetOnClickListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "postsarray"
private const val ARG_PARAM2 = "param2"

class HomeFragment(val arrayposts:ArrayList<Post>) : Fragment() {

//    private val photo_profile:Int? = null
//    private val post_photo:Int? =  null
//    private val display_name:String? = null
//    private val post_views:String? = null
//    private val post_description:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.home_recyclerview)
        val adapter = PostsAdapter()
        val lm = LinearLayoutManager(context)
        rv.layoutManager = lm
        rv.adapter = adapter
        adapter.setList(arrayposts)
        adapter.set_click_listener(object :SetOnClickListener{
            override fun OnPostClick(img: Int) {
                val intent = Intent(context ,Display_Post::class.java)
                intent.putExtra("image" ,img)
                startActivity(intent)
            }
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            HomeFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}