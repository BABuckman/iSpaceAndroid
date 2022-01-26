package com.babuckman.ispacekotlin.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnNextActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNextActivity = findViewById(R.id.moveToNext)

        btnNextActivity.setOnClickListener { nextActivity() }
    }

    fun nextActivity(){
        var intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun goToActivity(view: View) {
        var intent = Intent(this@MainActivity, ThirdActivity::class.java)
        startActivity(intent)
    }
}