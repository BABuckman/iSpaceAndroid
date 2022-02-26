package com.babuckman.ispacekotlin.myapplication.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityBookingBinding

class BookingActivity:AppCompatActivity() {

    lateinit var binding:ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}