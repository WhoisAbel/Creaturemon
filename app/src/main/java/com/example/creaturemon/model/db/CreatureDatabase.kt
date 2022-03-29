package com.example.creaturemon.model.db

import androidx.room.RoomDatabase

abstract class CreatureDatabase:RoomDatabase() {
    abstract fun creatureDao(): CreatureDao
}