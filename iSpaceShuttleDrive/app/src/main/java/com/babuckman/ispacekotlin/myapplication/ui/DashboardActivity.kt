package com.babuckman.ispacekotlin.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.MainActivity
import com.babuckman.ispacekotlin.myapplication.R
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    private lateinit var useridField: TextView
    private lateinit var emailField: TextView
    private lateinit var logout: Button
    private lateinit var bookRide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        useridField.text = "User ID :: $userId"
        emailField.text = "Email ID :: $emailId"

        logout.setOnClickListener {
            // Logout from app
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this@DashboardActivity, MainActivity::class.java))
            finish()
        }

        bookRide.setOnClickListener {
            // Go to Booking page
            startActivity(Intent(this@DashboardActivity, BookingActivity::class.java))

        }


    }
}