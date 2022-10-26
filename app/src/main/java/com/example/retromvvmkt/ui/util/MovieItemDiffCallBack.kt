package com.example.retromvvmkt.ui.util

import androidx.recyclerview.widget.DiffUtil
import com.example.retromvvmkt.data.model.Movie

class MovieItemDiffCallBack : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie):
            Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie):
            Boolean = oldItem.imageUrl == newItem.imageUrl


}