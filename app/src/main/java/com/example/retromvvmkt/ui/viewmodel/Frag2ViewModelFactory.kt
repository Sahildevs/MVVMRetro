package com.example.retromvvmkt.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retromvvmkt.data.repository.Frag2Repository

class Frag2ViewModelFactory constructor(private val fragRepository: Frag2Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(Frag2ViewModel::class.java)) {
            Frag2ViewModel(this.fragRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}