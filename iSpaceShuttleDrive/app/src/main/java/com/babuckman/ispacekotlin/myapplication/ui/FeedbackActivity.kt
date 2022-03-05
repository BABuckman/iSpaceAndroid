package com.babuckman.ispacekotlin.myapplication.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.R
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityFeedbackBinding

class FeedbackActivity : AppCompatActivity() {
    private lateinit var profileImage: ImageView
    private lateinit var feedbackfield: TextView
    private lateinit var commentfield: TextView
    lateinit var binding:ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        profileImage = findViewById(R.id.profileImage)
        feedbackfield = findViewById(R.id.feedback_field)
        commentfield = findViewById(R.id.comment_field)

        //add back button to action bar
        setSupportActionBar(binding.myToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
