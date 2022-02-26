package com.babuckman.ispacekotlin.myapplication.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.babuckman.ispacekotlin.myapplication.R
import com.babuckman.ispacekotlin.myapplication.data.BookingData
import com.babuckman.ispacekotlin.myapplication.data.BusData
import com.bumptech.glide.Glide

class BookingAdapter(val context: Context,
                     val busList:List<BusData>,
                     val bookingItem:HandleBookingClick,):
    RecyclerView.Adapter<BookingAdapter.ViewHolder>(){

    inner class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){

        //val busHeading: TextView = ItemView.findViewById(R.id.txtHeading)
        val busImage:ImageView = ItemView.findViewById(R.id.imgShuttle)
        val busType: TextView = ItemView.findViewById(R.id.txtBusType)
        val busNumber: TextView = ItemView.findViewById(R.id.txtBusNumber)
        //val busStart: TextView = ItemView.findViewById(R.id.txtStart)
        //val busDestination: TextView = ItemView.findViewById(R.id.txtDestination)
        //val busFare: TextView = ItemView.findViewById(R.id.txtFare)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.booking_items, parent, false)

        return ViewHolder(view)
    }

    interface HandleBookingClick{
        fun bookingClick(position:Int)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bus = busList[position]

        holder.busType.text = bus.busType
        holder.busNumber.text = bus.busNumber

        Glide.with(context)
            .load(bus.busImage)
            .into(holder.busImage)
    }

    override fun getItemCount(): Int {
        return busList.size
    }
}