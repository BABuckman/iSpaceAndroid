package com.babuckman.ispacekotlin.myapplication.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.text.format.DateFormat
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityBookingBinding
import java.util.*

class BookingActivity:AppCompatActivity(), DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    private lateinit var binding:ActivityBookingBinding
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0

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
        binding.txtBookingBusNumber.text = "Bus No.: ${busNumber.toString()}"
        //binding.txtBookingSeats.text = "No. of seats: " + busSeat.toString()

        binding.btnDateTimePick.setOnClickListener {
            val calender:Calendar = Calendar.getInstance()
            day = calender.get(Calendar.DAY_OF_MONTH)
            month = calender.get(Calendar.MONTH)
            year = calender.get(Calendar.YEAR)
            val datePicker = DatePickerDialog(this@BookingActivity,this@BookingActivity,year, month, day)
            datePicker.show()
        }
    }

    override fun onDateSet(p0: DatePicker?, yr: Int, mon: Int, dayofmonth: Int) {
        Toast.makeText(this, "Year: $yr Month: $mon Day: $dayofmonth", Toast.LENGTH_SHORT).show()
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePicker = TimePickerDialog(this,this,hour,minute,DateFormat.is24HourFormat(this))
        timePicker.show()
    }

    override fun onTimeSet(p0: TimePicker?, hr: Int, min: Int) {
        Toast.makeText(this, "Hour: $hr : $min ", Toast.LENGTH_SHORT).show()
    }
}
