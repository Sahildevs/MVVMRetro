package com.example.retromvvmkt.data.repository

import com.example.retromvvmkt.data.api.RetrofitService


class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}