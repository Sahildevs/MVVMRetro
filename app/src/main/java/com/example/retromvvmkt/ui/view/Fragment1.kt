package com.example.retromvvmkt.ui.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retromvvmkt.R
import com.example.retromvvmkt.data.api.RetrofitService
import com.example.retromvvmkt.data.repository.MainRepository
import com.example.retromvvmkt.databinding.Fragment1Binding
import com.example.retromvvmkt.ui.adapter.MainAdapter
import com.example.retromvvmkt.ui.viewmodel.MainViewModel
import com.example.retromvvmkt.ui.viewmodel.MainViewModelFactory
import com.google.android.material.appbar.MaterialToolbar


class Fragment1 : Fragment() {



    lateinit var binding: Fragment1Binding
    lateinit var mainViewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    //val adapter = MainAdapter()
    private lateinit var adapter : MainAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)



        mainViewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.apply {
            viewmodel = mainViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        binding.recyclerView.adapter = MainAdapter(MainAdapter.OnClickListner { movie ->

            Toast.makeText(activity, "${movie.name}", Toast.LENGTH_SHORT).show()

            val mName = movie.name
            val mDesc = movie.desc
            val mImage = movie.imageUrl

            val bundle = Bundle()
            bundle.putString("TITLE", mName)
            bundle.putString("DESC", mDesc)
            bundle.putString("IMG", mImage)
            binding.root.findNavController().navigate(R.id.action_fragment1_to_fragment4, bundle)



        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.movieList.observe(viewLifecycleOwner, Observer {
            binding.recyclerView.adapter?.notifyDataSetChanged()
        })
        mainViewModel.getAllMovies()
    }

    /*
    fun passData(movieTitle:String, movieDesc:String, movieImageUrl: String) {




        val fragment = Fragment4()
        val args = Bundle()
        args.putString("TITLE", movieTitle)
        args.putString("DESC", movieDesc)
        args.putString("IMG", movieImageUrl)
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.mainContainer, fragment)?.commit()





        //navigate to another fragment
        //view?.findNavController()?.navigate(R.id.fragment4)


    }

     */







}
