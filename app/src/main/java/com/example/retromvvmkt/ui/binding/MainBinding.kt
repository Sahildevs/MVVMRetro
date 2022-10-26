package com.example.retromvvmkt.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retromvvmkt.data.model.Movie
import com.example.retromvvmkt.ui.adapter.MainAdapter


@BindingAdapter("moviesList")
fun moviesList(recyclerView: RecyclerView, list: List<Movie>?) {
    val adapter = recyclerView.adapter as MainAdapter
     adapter.submitList(list)
}