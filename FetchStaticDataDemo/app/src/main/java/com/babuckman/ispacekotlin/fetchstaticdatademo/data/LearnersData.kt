package com.babuckman.ispacekotlin.fetchstaticdatademo.data

import com.squareup.moshi.Json

data class LearnersData(
    @Json(name = "first_name") val first_name:String,
    @Json(name = "last_name") val last_name:String,
    @Json(name = "email") val email:String,
    @Json(name = "gender") val gender: String,
    @Json(name = "profession") val profession:String,
    @Json(name = "phone_number") val phone_number:String,
    @Json(name = "location") val location:String,
    @Json(name = "image") val image: Int
)
