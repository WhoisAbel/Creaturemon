package com.example.creaturemon.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.creaturemon.model.CreatureRepository

@Suppress("UNCHECKED_CAST")
class CreatureViewModelFactory(private val repository: CreatureRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CreatureViewModel(repository) as T
    }
}