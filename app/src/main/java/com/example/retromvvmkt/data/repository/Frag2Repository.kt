package com.example.retromvvmkt.data.repository

import com.example.retromvvmkt.data.api.Api

class Frag2Repository constructor(private val api:Api) {

    suspend fun getMovies() = api.getMovies()
    suspend fun getDirectors() = api.getDirectors()
}