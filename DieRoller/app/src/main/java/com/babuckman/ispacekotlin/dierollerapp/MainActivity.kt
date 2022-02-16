package com.babuckman.ispacekotlin.dierollerapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.babuckman.ispacekotlin.dierollerapp.databinding.ActivityMainBinding
import com.babuckman.ispacekotlin.dierollerapp.ui.OneDiceFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //bind fragment object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add<OneDiceFragment>(R.id.container, null, null)
        }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item != null)
            when(item.itemId){
                R.id.oneDice -> {}
                R.id.twoDice -> {}
                R.id.quit -> {}
            }
        return true
    }
}