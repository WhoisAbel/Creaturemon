package com.example.creaturemon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "creature_table")
data class Creature(
    val creatureAttributes: CreatureAttributes,
    val hitPoints: Int = 0,
    @PrimaryKey @NotNull val name: String = "",
    val drawable: Int = 0
)