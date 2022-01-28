package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Post
import com.example.adapters.PostSavedAdapter
import com.example.govtech.AllPostSavedActivity
import com.example.govtech.DisplayPostActivity
import com.example.govtech.R
import com.example.interfaces.SetOnClickListener
import com.example.tools.RoundedTransformation
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment(val arrayposts_saved:ArrayList<Post>) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.rv_saved)
        val bu_see_all = view.findViewById<TextView>(R.id.bu_see_all)
        val adapter = PostSavedAdapter(requireContext())
        val lm = GridLayoutManager(context ,2)
        rv.layoutManager = lm
        rv.adapter = adapter

        adapter.setList(arrayposts_saved)
        adapter.set_click_listener(object : SetOnClickListener {
            override fun OnPostClick(img: Int) {
                val intent = Intent(context , DisplayPostActivity::class.java)
                intent.putExtra("image" ,img)
                startActivity(intent)
            }
        })

        bu_see_all.setOnClickListener {
            startActivity(Intent(context ,AllPostSavedActivity::class.java))
        }

        val image_profile = view.findViewById<ImageView>(R.id.image_profile)
        Picasso.with(context).load(R.drawable.user5_photo).transform(RoundedTransformation(50 ,30)).into(image_profile)


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            ProfileFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}