package com.babuckman.ispacekotlin.dierollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var dice:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice = findViewById(R.id.imageview)
        dice.setOnClickListener { rowDice() }
    }

    private fun rowDice() {

        val randomNum = (1..6).random()
        //Log.i("TAG","Clicked ${randomNum}")
        var imageResource = when(randomNum){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        dice.setImageResource(imageResource)
    }
}