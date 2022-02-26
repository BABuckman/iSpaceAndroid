package com.babuckman.ispacekotlin.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityBookingBinding

class BookingActivity:AppCompatActivity() {

    lateinit var binding:ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //retrieve bus information
        val intent = getIntent()
        val busType = intent.getStringExtra("busType")
        val busNumber = intent.getStringExtra("busNumber")
        val busSeat = intent.getStringExtra("busSeat")
        val busImage = intent.getStringExtra("busImage")

        binding.txtBookingBusType.text = busType.toString()
        binding.txtBookingBusNumber.text = busNumber.toString()
        binding.txtBookingSeats.text = busSeat.toString()
        
    }
}