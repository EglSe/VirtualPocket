package com.vpocket.myapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.vpocket.R

class ParentMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parent_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_vaikas1 -> {
                // Handle Today item click
                true
            }
            R.id.nav_vaikas2 -> {
                // Handle Week item click
                true
            }
            R.id.nav_pridetivaika -> {
                // Handle Month item click
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}