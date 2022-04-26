package com.example.creaturemon.view.allcreatures

import androidx.lifecycle.ViewModel
import com.example.creaturemon.model.CreatureRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllCreaturesViewModel(
    private val repository: CreatureRepository
) : ViewModel() {

    private val allCreatureLiveData = repository.getAllCreature()
    fun getAllCreature() = allCreatureLiveData

    fun clearAllCreatures() {
        val creatureArray = allCreatureLiveData.value?.toTypedArray()
        if (creatureArray != null) {
            CoroutineScope(Dispatchers.IO).launch {
                 repository.delete(*creatureArray)
            }
        }
    }
}