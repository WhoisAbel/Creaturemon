package com.example.creaturemon.view.allcreatures

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.creaturemon.model.CreatureRepository

class AllCreaturesViewModel(
    private val repository: CreatureRepository
) : ViewModel() {

    private val allCreatureLiveData = repository.getAllCreature()
    fun getAllCreature() = allCreatureLiveData

}