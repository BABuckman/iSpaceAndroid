package com.babuckman.ispacekotlin.myapplication.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.text.format.DateFormat
import android.widget.Toast
import android.widget.ToggleButton
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
    var assessibility:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //retrieve bus information
        val busHeading:String = intent.getStringExtra("busHeading").toString()
        val busType:String = intent.getStringExtra("busType").toString()
        val busNumber:String = intent.getStringExtra("busNumber").toString()
        val busSeat:Int = intent.getIntExtra("busSeat", 1).toInt()
        val busImage = intent.getIntExtra("busImage", 1).toInt()

        binding.txtBookingBusHeading.text = busHeading.toString()
        binding.txtBookingBusType.text = "Type: " + busType.toString()
        binding.txtBookingBusNumber.text = "Bus No.: ${busNumber.toString()}"
        binding.txtBookingSeats.text = "No. of seats: " + busSeat.toString()
        binding.imgBooking.setImageResource(busImage)

        binding.btnDatePick.setOnClickListener {
            val calender:Calendar = Calendar.getInstance()
            day = calender.get(Calendar.DAY_OF_MONTH)
            month = calender.get(Calendar.MONTH)
            year = calender.get(Calendar.YEAR)
            val datePicker = DatePickerDialog(this@BookingActivity,this@BookingActivity,year, month, day)
            datePicker.show()
        }

        binding.btnTimePick.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            hour = calendar.get(Calendar.HOUR)
            minute = calendar.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(this,this,hour,minute,DateFormat.is24HourFormat(this))
            timePicker.show()
        }

        binding.toggleRamp.setOnClickListener {tog->
            if(tog.isEnabled){
                //Set what happens to toggle button after click
                assessibility = true
            }else{
                Toast.makeText(this@BookingActivity, "No disability option", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBook.setOnClickListener {
            Toast.makeText(this@BookingActivity, "Success!", Toast.LENGTH_SHORT).show()
            var intent = Intent(this@BookingActivity, BookingSummaryActivity::class.java)
            intent.putExtra("busHeading", busHeading)
            intent.putExtra("busType", busType)
            intent.putExtra("busNumber", busNumber)
            intent.putExtra("busSeats", busSeat)
            intent.putExtra("busImage", busImage)
            intent.putExtra("day", day)
            intent.putExtra("month", month)
            intent.putExtra("year", year)
            intent.putExtra("hour", hour )
            intent.putExtra("minute",minute )
            intent.putExtra("assessibility", assessibility)
            startActivity(intent)
        }
        //add back button to action bar
        setSupportActionBar(binding.myToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDateSet(p0: DatePicker?, yr: Int, mon: Int, dayofmonth: Int) {
        Toast.makeText(this, "Year: $yr Month: $mon Day: $dayofmonth", Toast.LENGTH_SHORT).show()
    }

    override fun onTimeSet(p0: TimePicker?, hr: Int, min: Int) {
        Toast.makeText(this, "Hour: $hr : $min ", Toast.LENGTH_SHORT).show()
    }
}
