package com.example.creaturemon.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.creaturemon.model.Creature

@Dao
interface CreatureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(creature: Creature)

    @Delete
    suspend fun clearCreature(vararg creature: Creature)

    @Query("SELECT * FROM creature_table ORDER BY name ASC")
    fun getAllCreature(): LiveData<List<Creature>>
}