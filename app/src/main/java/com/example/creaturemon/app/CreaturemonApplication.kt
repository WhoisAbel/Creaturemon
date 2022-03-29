package com.example.creaturemon.app

import android.app.Application
import com.example.creaturemon.model.db.CreatureDatabase

class CreaturemonApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        // TODO: init database
    }
}