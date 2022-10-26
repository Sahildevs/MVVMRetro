package com.example.retromvvmkt.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retromvvmkt.data.model.Frag2RecyclerViewItem
import com.example.retromvvmkt.data.model.Movie
import com.example.retromvvmkt.data.repository.Frag2Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Frag2ViewModel (private val fragRepository: Frag2Repository): ViewModel() {


    val frag2ListItem = MutableLiveData<List<Frag2RecyclerViewItem>>()
    val errorMessage = MutableLiveData<String>()



    /*
    init {
        viewModelScope.launch {
            val moviesResponse = async { getMovies() }
            frag2ListItem.postValue(moviesResponse.await())

            val directorsResponse = async { getDirectors() }

            frag2ListItem.postValue(directorsResponse.await())
        }
    }

     */

    init {
        viewModelScope.launch {
            val moviesResponse = async { getMovies() }
            val directorsResponse = async { getDirectors() }


            val movies = moviesResponse.await()
            val directors = directorsResponse.await()

            val rec2ItemList = mutableListOf<Frag2RecyclerViewItem>()
            if (movies != null && directors != null) {
                rec2ItemList.addAll(movies)
                rec2ItemList.addAll(directors)

                frag2ListItem.postValue(rec2ItemList)
            }
        }
    }

    /*
    fun getAllData(){
        viewModelScope.launch {

            val response1 = fragRepository.getDirectors()
            val response2 = fragRepository.getMovies()

            if(response1.isSuccessful() && response2.isSuccessful()){

            }
        }
    }

     */

    private suspend fun getMovies() : List<Frag2RecyclerViewItem.Movie>?{
        return withContext(Dispatchers.IO){
            fragRepository.getMovies().body()
        }
    }

    private suspend fun getDirectors() : List<Frag2RecyclerViewItem.Director>?{
        return withContext(Dispatchers.IO){
            fragRepository.getDirectors().body()
        }
    }




}


