package com.babuckman.ispacekotlin.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import com.babuckman.ispacekotlin.myapplication.R
import com.babuckman.ispacekotlin.myapplication.data.BusData
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityHomeBinding
import com.babuckman.ispacekotlin.myapplication.util.BusAdapter
import com.babuckman.ispacekotlin.myapplication.util.Constants

class HomeActivity : AppCompatActivity() {


    //instantiate variables
    private lateinit var binding:ActivityHomeBinding
    private lateinit var adapter:BusAdapter
    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

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

        //get data from intent and place data in username on the drawer
//        val intent = getIntent()
//        var username:String = intent.getStringExtra("username").toString()

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
        adapter = BusAdapter(this, busList,object:BusAdapter.HandleBookingClick{
            override fun bookingClick(position: Int) {

                val allBuses = busList[position]
                val busType:String = allBuses.busType
                val busNumber:String = allBuses.busNumber
                val seats:Int = allBuses.seats
                val busImage:Int = allBuses.busImage

                val intent = Intent(this@HomeActivity, BookingActivity::class.java)
                intent.putExtra("busType",busType)
                intent.putExtra("busNumber",busNumber)
                intent.putExtra("busSeat",seats)
                intent.putExtra("busImage",busImage)
                startActivity(intent)
//                val allBuses = busList[position]
//                val busType:String = allBuses.busType
//                val busNumber:String = allBuses.busNumber
//                val busImage:Int = allBuses.busImage
            }

        })
        binding.recyclerView.adapter = adapter


        //get data from intent and place data in username on the drawer
//        val intent = getIntent()
//        var username:String = intent.getStringExtra("username").toString()

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
        intent = Intent(this, FeedbackActivity::class.java)
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

    private fun goToBooking(): Boolean {
        //Toast.makeText(this@HomeActivity, "Success! To Booking", Toast.LENGTH_SHORT).show()
        intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        return true
    }
}