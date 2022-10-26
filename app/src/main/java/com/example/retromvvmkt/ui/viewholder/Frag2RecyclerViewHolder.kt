package com.example.retromvvmkt.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.retromvvmkt.R
import com.example.retromvvmkt.data.model.Frag2RecyclerViewItem
import com.example.retromvvmkt.databinding.ItemDirectorBinding
import com.example.retromvvmkt.databinding.ItemMovieBinding

sealed class Frag2RecyclerViewHolder(binding: ViewBinding): RecyclerView.ViewHolder(binding.root){

    class MovieViewHolder(private val binding: ItemMovieBinding) : Frag2RecyclerViewHolder(binding){
        fun bind(movie : Frag2RecyclerViewItem.Movie){
            binding.tvMovieName.text = movie.title
            Glide.with(binding.ivMovie).load(movie.thumbnail).placeholder(R.drawable.profile).into(binding.ivMovie)
        }
    }

    class DirectorViewHolder(private val binding: ItemDirectorBinding) : Frag2RecyclerViewHolder(binding){
        fun bind(director: Frag2RecyclerViewItem.Director){
            binding.tvDirectorName.text = director.name
            binding.tvMoviesCount.text = director.movie_count.toString()
            Glide.with(binding.ivDirector).load(director.avatar).into(binding.ivDirector)
        }
    }



}
