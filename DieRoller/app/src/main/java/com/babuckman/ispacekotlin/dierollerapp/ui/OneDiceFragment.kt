package com.babuckman.ispacekotlin.dierollerapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.babuckman.ispacekotlin.dierollerapp.R

class OneDiceFragment : Fragment() {
    lateinit var dice: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //dice = findViewById(R.id.imageview)
        //dice.setOnClickListener { rowDice() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_dice, container, false)
    }

    private fun rowDice() {

        val randomNum = (1..6).random()
        //Log.i("TAG","Clicked ${randomNum}")
        var imageResource = when(randomNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        dice.setImageResource(imageResource)
    }
}