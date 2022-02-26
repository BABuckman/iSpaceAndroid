package com.babuckman.ispacekotlin.myapplication.data

import android.content.Context
import com.babuckman.ispacekotlin.myapplication.util.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class BookingRepository {
    private val listype = Types.newParameterizedType(
        List::class.java,BookingData::class.java
    )

    fun getBookingData(context: Context):List<BookingData>{
        val text = FileHelper.getTextFromAssets(context, "booking.json")
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter: JsonAdapter<List<BookingData>> =
            moshi.adapter(listype)
        return adapter.fromJson(text) ?: emptyList()
    }
}