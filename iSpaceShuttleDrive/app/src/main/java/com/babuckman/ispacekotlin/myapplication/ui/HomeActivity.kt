package com.babuckman.ispacekotlin.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import com.babuckman.ispacekotlin.myapplication.R

class HomeActivity : AppCompatActivity() {
    //instantiate variables
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        //setup variables
        toolbar = findViewById(R.id.toolbar)
       // toggle = ActionBarDrawerToggle(this,toolbar,R.string.openDrawer, R.string.closeDrawer )
    }
}