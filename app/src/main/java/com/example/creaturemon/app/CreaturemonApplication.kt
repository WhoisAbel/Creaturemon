package com.example.creaturemon.app

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.creaturemon.app.di.ViewModelFactory
import com.example.creaturemon.app.di.bindViewModel
import com.example.creaturemon.model.CreatureRepository
import com.example.creaturemon.model.db.CreatureDatabase
import com.example.creaturemon.view.allcreatures.AllCreaturesViewModel
import com.example.creaturemon.view.creature.CreatureViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CreaturemonApplication:Application(),KodeinAware {


    override val kodein by Kodein.lazy {

        import(androidXModule(this@CreaturemonApplication))
        bind() from singleton { CreatureDatabase(instance()) }
        bind() from singleton { CreatureRepository(instance()) }

        bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(kodein.direct) }

        bindViewModel<AllCreaturesViewModel>() with provider {
            AllCreaturesViewModel(instance())
        }

        bindViewModel<CreatureViewModel>() with provider {
            CreatureViewModel(instance())
        }


    }
}