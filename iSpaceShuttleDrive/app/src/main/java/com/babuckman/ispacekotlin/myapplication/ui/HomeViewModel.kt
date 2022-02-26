package com.babuckman.ispacekotlin.myapplication.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.babuckman.ispacekotlin.myapplication.data.BookingData
import com.babuckman.ispacekotlin.myapplication.data.BookingRepository

class HomeViewModel(app:Application):AndroidViewModel(app) {
    private val dataRepo = BookingRepository()
    val selectedBus = MutableLiveData<BookingData>()
    init {
        val buses = dataRepo.getBookingData(app)

        for (bus in buses){
            //Log.i("DATA","${bus.busNumber}${bus.busType}(\$${bus.seats})")
        }
    }
}