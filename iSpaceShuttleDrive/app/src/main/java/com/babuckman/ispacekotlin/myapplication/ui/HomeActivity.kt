package com.babuckman.ispacekotlin.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.babuckman.ispacekotlin.myapplication.R
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {
    //instantiate variables
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //setup variables
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        //this makes the menu icon on the toolbar clickable
       toggle = ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.openDrawer, R.string.closeDrawer )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Set navigation listener
        navigationView.setNavigationItemSelectedListener { data->
            when(data.itemId){
                R.id.Booking -> goToBooking()
                R.id.Invoice -> goToInvoice()
                R.id.History -> goToHistory()
                R.id.Feedback -> goToFeedback()
                R.id.Rateus -> goToRate()
                R.id.Logout -> goToLogout()
                else -> false
            }
        }
    }

    private fun goToLogout():Boolean {
        Toast.makeText(this@HomeActivity, "Success! To logout", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun goToRate():Boolean{
        Toast.makeText(this@HomeActivity, "Success! To Rate us", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun goToFeedback():Boolean {
        Toast.makeText(this@HomeActivity, "Success! To Feedback", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun goToHistory(): Boolean {
        Toast.makeText(this@HomeActivity, "Success! To History", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun goToInvoice(): Boolean {
        Toast.makeText(this@HomeActivity, "Success! To Invoice", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun goToBooking(): Boolean {
        Toast.makeText(this@HomeActivity, "Success! To Booking", Toast.LENGTH_SHORT).show()
        return true
    }
}