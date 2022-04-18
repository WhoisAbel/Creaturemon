package com.example.creaturemon.view.allcreatures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.creaturemon.model.CreatureRepository
import com.example.creaturemon.view.creature.CreatureViewModel

@Suppress("UNCHECKED_CAST")
class AllCreatureViewModelFactory(private val repository: CreatureRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AllCreaturesViewModel(repository) as T
    }
}