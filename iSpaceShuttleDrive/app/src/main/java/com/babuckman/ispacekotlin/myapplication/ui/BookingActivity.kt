package com.babuckman.ispacekotlin.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityBookingBinding

class BookingActivity:AppCompatActivity() {

    private lateinit var binding:ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //retrieve bus information
        val intent = getIntent()
        val busType:String = intent.getStringExtra("busType").toString()
        val busNumber:String = intent.getStringExtra("busNumber").toString()
        //val busSeat:String = intent.getIntExtra("busSeat")
        val busImage = intent.getStringExtra("busImage")

        binding.txtBookingBusType.text = "Type: " + busType.toString()
        binding.txtBookingBusNumber.text = "Bus No.: " + busNumber.toString()
        //binding.txtBookingSeats.text = "No. of seats: " + busSeat.toString()

    }
}
