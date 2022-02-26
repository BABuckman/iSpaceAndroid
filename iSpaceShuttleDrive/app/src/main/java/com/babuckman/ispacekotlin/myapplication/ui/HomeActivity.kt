package com.babuckman.ispacekotlin.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.babuckman.ispacekotlin.myapplication.R
import com.babuckman.ispacekotlin.myapplication.data.BookingData
import com.babuckman.ispacekotlin.myapplication.data.BusData
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityHomeBinding
import com.babuckman.ispacekotlin.myapplication.util.BookingAdapter
import com.babuckman.ispacekotlin.myapplication.util.Constants
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    //instantiate variables
    lateinit var binding:ActivityHomeBinding
    lateinit var adapter:BookingAdapter
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var viewModel:HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup variables
        toolbar = findViewById(R.id.toolbar)

        //this makes the menu icon on the toolbar clickable
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout, toolbar,R.string.openDrawer, R.string.closeDrawer )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //set adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this,1)
        val busList = ArrayList<BusData>()

        //hardcode some buses for testing
        busList.add(
            BusData("GS-001-22","Non AC", 32, Constants.bus01)
        )
        busList.add(
            BusData("GS-002-22","AC", 24, Constants.bus02)
        )
        busList.add(
            BusData("GS-020-22","AC", 50, Constants.bus03)
        )
        adapter = BookingAdapter(this, busList,object:BookingAdapter.HandleBookingClick{
            override fun bookingClick(position: Int) {
                val allBuses = busList[position]
                val busType:String = allBuses.busType
                val busNumber:String = allBuses.busNumber
                val busImage:Int = allBuses.busImage
            }

        })
        binding.recyclerView.adapter = adapter

        //get data from intent and place data in username on the drawer
        val intent = getIntent();
        var username:String = intent.getStringExtra("username").toString()

        //Set navigation listener
        binding.navView.setNavigationItemSelectedListener { data->
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
        //Toast.makeText(this@HomeActivity, "Success! To Booking", Toast.LENGTH_SHORT).show()
        intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        return true
    }
}