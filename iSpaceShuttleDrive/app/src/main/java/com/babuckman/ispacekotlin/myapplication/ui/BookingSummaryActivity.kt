package com.babuckman.ispacekotlin.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.babuckman.ispacekotlin.myapplication.R
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityBookingSummaryBinding

class BookingSummaryActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBookingSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //retrieve bus information
        val busHeading:String = intent.getStringExtra("busHeading").toString()
        val busType:String = intent.getStringExtra("busType").toString()
        val busNumber:String = intent.getStringExtra("busNumber").toString()
        val busSeat:Int = intent.getIntExtra("busSeat", 1).toInt()
        val busImage = intent.getIntExtra("busImage", 1).toInt()
        val day:Int = intent.getIntExtra("day", 1).toInt()
        val month:Int = intent.getIntExtra("month", 1).toInt()
        val year:Int = intent.getIntExtra("year", 1).toInt()
        val hour:Int = intent.getIntExtra("hour", 1).toInt()
        val minute:Int = intent.getIntExtra("minute", 1).toInt()
        val assessibility:Boolean = intent.getBooleanExtra("assessibility",false)

        //set the values to the respective placeholders
        binding.txtBookingBusHeading.text = busHeading.toString()
        binding.txtBookingBusType.text = "Type: ${busType.toString()}"
        binding.txtBookingBusNumber.text = "Bus No.: ${busNumber.toString()}"
        binding.txtBookingSeats.text = "No. of seats: ${busSeat.toString()}"
        binding.imgBooking.setImageResource(busImage)
        binding.txtBookingDate.text = "Departure Date: ${day} - ${month} - ${year}"
        binding.txtBookingTime.text = "Departure Time: ${hour} : ${minute}"
        binding.txtBookingAssessibility.text = "Provide Ramp: ${assessibility}"

        //Button for payment
        binding.btnConfirm.setOnClickListener {
            Toast.makeText(this, "To Payment Portal", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@BookingSummaryActivity, HomeActivity::class.java))
        }

        //add back button to action bar
        setSupportActionBar(binding.lastToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}