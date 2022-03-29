package com.example.creaturemon.model.db

import androidx.room.TypeConverter
import com.example.creaturemon.model.CreatureAttributes
import java.util.*

class CreatureAttributesConverter {

    @TypeConverter
    fun fromCreatureAttributes(attCreatureAttributes: CreatureAttributes?): String? {
        if (attCreatureAttributes != null)
            return String.format(
                Locale.US,
                "%d,%d,%d",
                attCreatureAttributes.intelligence,
                attCreatureAttributes.strength,
                attCreatureAttributes.endurance
            )
        return null
    }

    @TypeConverter
    fun toCreatureAttributes(value: String?): CreatureAttributes? {
        if (value != null) {
            val pieces = value.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return CreatureAttributes(
                intelligence = pieces[0].toInt(),
                strength = pieces[0].toInt(),
                endurance = pieces[0].toInt()
            )
        }
        return null
    }
}