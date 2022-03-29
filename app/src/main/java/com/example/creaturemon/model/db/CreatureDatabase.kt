package com.example.creaturemon.model.db

import android.content.Context
import androidx.room.*
import com.example.creaturemon.model.Creature

@Database(entities = [Creature::class], version = 1)
@TypeConverters(CreatureAttributesConverter::class)
abstract class CreatureDatabase : RoomDatabase() {
    abstract fun creatureDao(): CreatureDao

    companion object {
        @Volatile
        private var instance: CreatureDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CreatureDatabase::class.java,
                "creature_database"
            ).build()
    }
}