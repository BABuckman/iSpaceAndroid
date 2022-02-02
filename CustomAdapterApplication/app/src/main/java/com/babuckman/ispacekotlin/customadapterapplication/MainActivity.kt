package com.babuckman.ispacekotlin.customadapterapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //Create an instance of the recyclerView
    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //refer to the instance of the view object
        recyclerView = findViewById(R.id.recyclerview)
    }
}