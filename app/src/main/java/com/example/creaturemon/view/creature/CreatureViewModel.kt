package com.example.creaturemon.view.creature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.creaturemon.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreatureViewModel(
    private val creatureRepository: CreatureRepository
) : ViewModel() {

    var name = ""
    var intelligence: Int = 0
    var strength: Int = 0
    var endurance: Int = 0
    var drawable: Int = 0

    lateinit var creature: Creature

    val creatureLiveData = MutableLiveData<Creature>()
    fun creatureLiveData(): LiveData<Creature> = creatureLiveData

    private fun updateCreature() {
        val attributes = CreatureAttributes(
            intelligence = intelligence,
            strength = strength,
            endurance = endurance
        )
        creature = Creature(
            creatureAttributes = attributes,
            hitPoints = attributes.calculateHitPoint(),
            name = name,
            drawable = drawable,
        )

        creatureLiveData.postValue(creature)
    }


    fun attributeSelected(attributeType: AttributeType, position: Int) {
        when (attributeType) {
            AttributeType.INTELLIGENCE ->
                intelligence = AttributeStore.INTELLIGENCE[position].value
            AttributeType.STRENGTH ->
                strength = AttributeStore.STRENGTH[position].value
            AttributeType.ENDURANCE ->
                endurance = AttributeStore.ENDURANCE[position].value
        }
        updateCreature()
    }

    fun drawableSelected(drawable: Int) {
        this.drawable = drawable
        updateCreature()
    }

    fun saveCreature() {
        CoroutineScope(Dispatchers.Main).launch {
            if (canSaveCreature()) {
                creatureRepository.insert(creature)
            }
        }
    }

    private fun canSaveCreature(): Boolean {
        return intelligence != 0 && strength != 0 && endurance != 0 && name.isNotEmpty() && drawable != 0
    }

}