package com.example.retromvvmkt.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.retromvvmkt.R
import com.example.retromvvmkt.data.api.Api
import com.example.retromvvmkt.data.repository.Frag2Repository
import com.example.retromvvmkt.data.repository.MainRepository
import com.example.retromvvmkt.databinding.Fragment2Binding
import com.example.retromvvmkt.ui.adapter.Frag2RecyclerViewAdapter
import com.example.retromvvmkt.ui.viewmodel.Frag2ViewModel
import com.example.retromvvmkt.ui.viewmodel.Frag2ViewModelFactory
import com.example.retromvvmkt.ui.viewmodel.MainViewModel
import com.example.retromvvmkt.ui.viewmodel.MainViewModelFactory


class Fragment2 : Fragment() {


    lateinit var binding : Fragment2Binding
    private val retrofitService2 = Api.getInstance()
    private lateinit var frag2RecyclerViewAdapter : Frag2RecyclerViewAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)

        frag2RecyclerViewAdapter = Frag2RecyclerViewAdapter()


        binding.recyclerView2.adapter = frag2RecyclerViewAdapter
        binding.recyclerView2.layoutManager = LinearLayoutManager(activity)

        val frag2ViewModel = ViewModelProvider(this, Frag2ViewModelFactory(Frag2Repository(retrofitService2))).get(
            Frag2ViewModel::class.java)


        frag2ViewModel.frag2ListItem.observe(viewLifecycleOwner, Observer {

            frag2RecyclerViewAdapter.updateList(it)
            frag2RecyclerViewAdapter.notifyDataSetChanged()

        })




        return binding.root
    }


}