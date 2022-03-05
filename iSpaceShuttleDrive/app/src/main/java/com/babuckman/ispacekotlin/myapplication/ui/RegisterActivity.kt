package com.babuckman.ispacekotlin.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.MainActivity
import com.babuckman.ispacekotlin.myapplication.R

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {

    private lateinit var banner : TextView
    private lateinit var bannerDescription: TextView
    private lateinit var fullName: EditText
    private lateinit var age: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var registerUser: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        banner = findViewById(R.id.banner)
        bannerDescription = findViewById(R.id.bannerDescription)
        fullName = findViewById(R.id.fullName)
        age = findViewById(R.id.age)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        registerUser = findViewById(R.id.registerUser)

        registerUser.setOnClickListener {
            when {
                TextUtils.isEmpty(fullName.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter your fullname",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(age.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter your age",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(email.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter your email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(password.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter your password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {

                    val fullName: String = fullName.text.toString().trim { it <= ' ' }
                    val age: String = age.text.toString().trim { it <= ' ' }
                    val email: String = email.text.toString().trim { it <= ' ' }
                    val password: String = password.text.toString().trim { it <= ' ' }

                    // Create an instance and create a register user with email and password
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            // If the registration is successfully done
                            if (task.isSuccessful) {

                                // Firebase registered user
                                val firebaseUser: FirebaseUser = task.result!!.user!!


                                Toast.makeText(
                                    this@RegisterActivity,
                                    "You are registered successfully",

                                    Toast.LENGTH_SHORT
                                ).show()

                                /**
                                 * Here the new user registered is automatically signed-in so we just sign-out
                                 * and send the user to Main screen with user id an email that he has used for registering
                                 * */

                                val intent =
                                    Intent(this@RegisterActivity, DashboardActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {
                                // If the registration is not successful then show error message
                                Toast.makeText(
                                    this@RegisterActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }

            }
        }

    }
}
