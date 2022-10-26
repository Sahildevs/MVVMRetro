package com.example.retromvvmkt.data.api

import com.example.retromvvmkt.data.model.Frag2RecyclerViewItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//https://60d194a45b017400178f3e51.mockapi.io/movies
//https://60d194a45b017400178f3e51.mockapi.io/directors

interface Api {

    @GET("movies")
    suspend fun getMovies(): Response<List<Frag2RecyclerViewItem.Movie>>

    @GET("directors")
    suspend fun getDirectors():  Response<List<Frag2RecyclerViewItem.Director>>

    companion object {
        var api: Api? = null

        fun getInstance() : Api {
            if (api == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://60d194a45b017400178f3e51.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                api = retrofit.create(Api::class.java)
            }
            return api!!
        }
    }
}