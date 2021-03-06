package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Post
import com.example.adapters.PostsAdapter
import com.example.govtech.DisplayPostActivity
import com.example.govtech.R
import com.example.interfaces.SetOnClickListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrganisateurFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrganisateurFragment(val arrayposts:ArrayList<Post>) : Fragment() {
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
        val view:View = inflater.inflate(R.layout.fragment_organisateur, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.org_recyclerview)
        val adapter = PostsAdapter(requireContext())
        val lm = LinearLayoutManager(context)
        rv.layoutManager = lm
        rv.adapter = adapter
        rv.hasFixedSize()
        rv.isNestedScrollingEnabled = false
        lm.isSmoothScrolling
        adapter.setList(arrayposts)
        adapter.set_click_listener(object : SetOnClickListener {
            override fun OnPostClick(img: Int) {
                val intent = Intent(context , DisplayPostActivity::class.java)
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
         * @return A new instance of fragment OrganisateurFragment.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            OrganisateurFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}