package com.babuckman.ispacekotlin.myapplication.data

import com.squareup.moshi.Json

data class BookingData(
    @Json(name = "start") var boardingPoint:String,
    @Json(name = "destination") var droppingPoint:String,
    @Json(name = "date") var date:String,
    @Json(name = "time") var startTime:String,
    @Json(name = "fare") var fare:Double,
)
