package com.example.creaturemon.view.allcreatures

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.creaturemon.R
import com.example.creaturemon.view.creature.CreatureActivity
import kotlinx.android.synthetic.main.activity_all_creatures.*
import kotlinx.android.synthetic.main.content_all_creatures.*

class AllCreaturesActivity : AppCompatActivity() {

    private val adapter = CreatureAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_creatures)
        setSupportActionBar(toolbar)

        creaturesRecyclerView.layoutManager = LinearLayoutManager(this)
        creaturesRecyclerView.adapter = adapter

        fab.setOnClickListener {
            startActivity(Intent(this, CreatureActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear_all -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
