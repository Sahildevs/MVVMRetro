package com.example.retromvvmkt.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.retromvvmkt.R
import com.google.android.material.appbar.MaterialToolbar


class Fragment4 : Fragment() {


    val args: Fragment4Args by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_4, container, false)





        var title = view.findViewById<TextView>(R.id.tvName)
        var description = view.findViewById<TextView>(R.id.tvDesc)
        var image = view.findViewById<ImageView>(R.id.img)

        //GETTING VALUES FROM ANOTHER FRAGMENT

        var mTitle = arguments?.getString("TITLE")
        val mDesc = arguments?.getString("DESC")
        val mImage = arguments?.getString("IMG")



        //SETTING VALUES TO ELEMENTS
        title.text = mTitle
        description.text = mDesc
        Glide.with(this).load(mImage).into(image)


        return view
    }

}


