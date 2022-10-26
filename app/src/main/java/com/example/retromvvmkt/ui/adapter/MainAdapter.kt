package com.example.retromvvmkt.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retromvvmkt.R
import com.example.retromvvmkt.data.model.Movie
import com.example.retromvvmkt.databinding.Fragment1Binding
import com.example.retromvvmkt.databinding.LitemLayoutBinding
import com.example.retromvvmkt.ui.binding.moviesList
import com.example.retromvvmkt.ui.util.MovieItemDiffCallBack


class MainAdapter(private val onClickListner : OnClickListner): ListAdapter<Movie, MainAdapter.MainViewHolder>(MovieItemDiffCallBack()) {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val binding = LitemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)

    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val movie = getItem(position)
        holder.bind(movie)

        holder.binding.root.setOnClickListener {
            onClickListner.onClick(movie)
        }


        /*

        val movie = movies[position]

        holder.movieTitle.text = movie.name
        holder.movieDesc.text = movie.desc
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.movieImage)

        holder.itemView.setOnClickListener{
            onClickListner.onClick(movie)
        }

         */
    }



/*
    override fun getItemCount(): Int {
        return movies.size

    }

 */

    /*
    class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var movieImage = itemView.findViewById<ImageView>(R.id.imageView)
        var movieTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        var movieDesc = itemView.findViewById<TextView>(R.id.tvDescription)
    }

     */

    class MainViewHolder(val binding : LitemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie ) {
            binding.movie = movie
            binding.executePendingBindings()
            Glide.with(binding.imageView).load(movie.imageUrl).placeholder(R.drawable.profile).into(binding.imageView)
        }



    }

    class OnClickListner(val clickListner: (movie : Movie) -> Unit){
        fun onClick(movie: Movie) = clickListner(movie)
    }




}




