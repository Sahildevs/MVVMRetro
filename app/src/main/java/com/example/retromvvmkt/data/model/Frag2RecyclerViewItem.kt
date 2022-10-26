package com.example.retromvvmkt.data.model

sealed class Frag2RecyclerViewItem{

    class Movie(
        val id: Int,
        val title: String,
        val thumbnail: String,
        val release_date: String
    ): Frag2RecyclerViewItem()

    class Director(
        val id: Int,
        val name: String,
        val avatar: String,
        val movie_count: Int
    ): Frag2RecyclerViewItem()
}
