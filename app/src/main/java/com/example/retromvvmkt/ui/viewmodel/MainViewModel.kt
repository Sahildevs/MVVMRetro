package com.example.retromvvmkt.ui.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retromvvmkt.data.model.Movie
import com.example.retromvvmkt.data.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {


    private val _movieList =  MutableLiveData<List<Movie>>()
    val movieList : LiveData<List<Movie>> = _movieList

    val errorMessage = MutableLiveData<String>()

    init {
        _movieList.value = arrayListOf()
    }

    fun getAllMovies() {

        val response = repository.getAllMovies()

        response.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                _movieList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {

                errorMessage.postValue(t.message)
            }
        })
    }


}