package com.example.retromvvmkt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retromvvmkt.R
import com.example.retromvvmkt.data.model.Frag2RecyclerViewItem
import com.example.retromvvmkt.data.model.Movie
import com.example.retromvvmkt.databinding.ItemDirectorBinding
import com.example.retromvvmkt.databinding.ItemMovieBinding
import com.example.retromvvmkt.ui.viewholder.Frag2RecyclerViewHolder
import java.lang.IllegalArgumentException

class Frag2RecyclerViewAdapter(): RecyclerView.Adapter<Frag2RecyclerViewHolder>() {



    var items = listOf<Frag2RecyclerViewItem>()


    fun updateList(list : List<Frag2RecyclerViewItem>){
        items = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Frag2RecyclerViewHolder {
        return when(viewType){

            R.layout.item_movie -> Frag2RecyclerViewHolder.MovieViewHolder(
                ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            R.layout.item_director -> Frag2RecyclerViewHolder.DirectorViewHolder(
                ItemDirectorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type provided")
        }


    }

    override fun onBindViewHolder(holder: Frag2RecyclerViewHolder, position: Int) {
        when(holder){

            is Frag2RecyclerViewHolder.MovieViewHolder -> holder.bind(items[position] as Frag2RecyclerViewItem.Movie)
            is Frag2RecyclerViewHolder.DirectorViewHolder -> holder.bind(items[position] as Frag2RecyclerViewItem.Director)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //Inside this function we are checking what is the type of current item based on that we are returning the layout id
    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is Frag2RecyclerViewItem.Movie -> R.layout.item_movie
            is Frag2RecyclerViewItem.Director -> R.layout.item_director
        }
    }
}