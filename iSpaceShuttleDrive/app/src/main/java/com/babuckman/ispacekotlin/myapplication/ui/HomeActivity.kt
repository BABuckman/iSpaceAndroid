package com.babuckman.ispacekotlin.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import com.babuckman.ispacekotlin.myapplication.MainActivity
import com.babuckman.ispacekotlin.myapplication.R
import com.babuckman.ispacekotlin.myapplication.data.BusData
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityHomeBinding
import com.babuckman.ispacekotlin.myapplication.util.BusAdapter
import com.babuckman.ispacekotlin.myapplication.util.Constants

class HomeActivity : AppCompatActivity() {


    //instantiate variables
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter:BusAdapter
    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private var username:String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set up data binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup variables
        toolbar = findViewById(R.id.toolbar)
        //get data from MainActivity intent and place data into drawer username field
        username = intent.getStringExtra("username").toString()
        Toast.makeText(this, "Username: $username", Toast.LENGTH_SHORT).show()
        /*tv_username = findViewById(R.id.username)
        tv_username.text = "Hi, $username"*/

        //this makes the menu icon on the toolbar clickable
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout, toolbar,R.string.openDrawer, R.string.closeDrawer )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Set navigation listener
        binding.navView.setNavigationItemSelectedListener { data->
            when(data.itemId){
                R.id.booking -> goToBooking()
                R.id.invoice -> goToInvoice()
                R.id.history -> goToHistory()
                R.id.feedback -> goToFeedback()
                R.id.rateus -> goToRate()
                R.id.logout -> goToLogout()
                R.id.promotions -> goToPromotions()
                else -> false
            }
        }
        //set adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this,1)
        val busList = ArrayList<BusData>()

        //hardcode some buses for testing
        busList.add(
            BusData("Shuttle Bus","GS-020-22","AC", 32, Constants.bus03)
        )
        busList.add(
            BusData("Saloon Car","GS-001-22","AC", 5, Constants.bus04)
        )
        busList.add(
            BusData("Shuttle Bus","GS-041-20","Non AC", 32, Constants.bus06)
        )
        busList.add(
            BusData("School Shuttle","GH-711-22","AC", 32, Constants.bus07)
        )

        adapter = BusAdapter(this, busList,object:BusAdapter.HandleBookingClick{
            override fun bookingClick(position: Int) {

                val allBuses = busList[position]
                val busHeading = allBuses.busHeading
                val busType:String = allBuses.busType
                val busNumber:String = allBuses.busNumber
                val seats:Int = allBuses.seats
                val busImage:Int = allBuses.busImage

                //Intent to send the chosen bus data to next activity
                intent = Intent(this@HomeActivity, BookingActivity::class.java)
                intent.putExtra("busHeading",busHeading)
                intent.putExtra("busType",busType)
                intent.putExtra("busNumber",busNumber)
                intent.putExtra("busSeat",seats)
                intent.putExtra("busImage",busImage)
                startActivity(intent)
            }
        })
        //set the recyclerView adapter
        binding.recyclerView.adapter = adapter
    }

    private fun goToPromotions(): Boolean {
        Toast.makeText(this@HomeActivity, "Success! To Promotions", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun goToLogout():Boolean {
        //Toast.makeText(this@HomeActivity, "Success! To logout", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@HomeActivity, MainActivity::class.java)
        startActivity(intent)
        return true
    }

    private fun goToRate():Boolean{
        Toast.makeText(this@HomeActivity, "Success! To Rate us", Toast.LENGTH_SHORT).show()
        return true
    }

    private fun goToFeedback():Boolean {
        var intent = Intent(this@HomeActivity, FeedbackActivity::class.java)
        startActivity(intent)
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

    private fun goToBooking():Boolean {
        Toast.makeText(this@HomeActivity, "Success! To Booking", Toast.LENGTH_SHORT).show()
        var intent = Intent(this@HomeActivity, HomeActivity::class.java)
        startActivity(intent)
        return true
    }
}