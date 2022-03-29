package com.example.creaturemon.model

data class Creature(
    val creatureAttributes: CreatureAttributes,
    val hitPoints: Int = 0,
    val name: String = "",
    val drawable: Int = 0
) {
    private val hitPointsCalculate =
        creatureAttributes.intelligence * 5 + creatureAttributes.strength * 4 + creatureAttributes.endurance * 3

    fun creatureGenerator() = Creature(creatureAttributes, hitPointsCalculate, name, drawable)
}