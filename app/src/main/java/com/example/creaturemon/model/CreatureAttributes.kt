package com.example.creaturemon.model

data class CreatureAttributes(
    val intelligence: Int = 0,
    val strength: Int = 0,
    val endurance: Int = 0
) {

    fun calculateHitPoint() =
        intelligence * 5 + strength * 4 + endurance * 3
}