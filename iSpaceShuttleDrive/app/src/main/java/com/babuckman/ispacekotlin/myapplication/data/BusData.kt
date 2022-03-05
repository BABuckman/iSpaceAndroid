package com.babuckman.ispacekotlin.myapplication.data

import com.squareup.moshi.Json

data class BusData(
    @Json(name = "busHeading") var busHeading:String,
    @Json(name = "busNumber") var busNumber:String,
    @Json(name = "type") var busType:String,
    @Json(name = "seats") var seats:Int,
    @Json(name = "image") var busImage:Int,
)
