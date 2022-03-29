package com.example.creaturemon.model

import com.example.creaturemon.model.db.CreatureDatabase

class CreatureRepository(
    private val db: CreatureDatabase
) {
    suspend fun insert(creature: Creature) = db.creatureDao().insert(creature)

    suspend fun delete(vararg creature: Creature) = db.creatureDao().clearCreature(*creature)

    fun getAllCreature() = db.creatureDao().getAllCreature()
}