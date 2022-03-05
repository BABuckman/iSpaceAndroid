package com.babuckman.ispacekotlin.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityMainBinding
import com.babuckman.ispacekotlin.myapplication.ui.DashboardActivity
import com.babuckman.ispacekotlin.myapplication.ui.HomeActivity
import com.babuckman.ispacekotlin.myapplication.ui.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    //Variables
    lateinit var binding:ActivityMainBinding
    var username:String = ""
    var password:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //bind view to object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //handle button click event
        binding.btnLogin.setOnClickListener{
            //Log.i("TAG", "Login page worked") // Log for testing click event
            loginNow()
        }

        //send new user to register page
        binding.goToRegisterPage.setOnClickListener{
            var intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun loginNow() {


        username = binding.edtUsername.text.toString()
        password = binding.editTextPassword.text.toString()

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(
                this,
                "Please enter your email",
                Toast.LENGTH_SHORT
                ).show()
        }
        else {
            val email: String = username.trim { it <= ' '}
            val password: String = password.trim { it <= ' ' }

            // Log In using FirebaseAuth
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {

                        Toast.makeText(
                            this@MainActivity,
                            "You are logged in successfully",
                            Toast.LENGTH_SHORT
                        ).show()

                            /**
                             * Here the new user registered is automatically signed-in so we just sign-out
                             * and send the user to Main screen with user id an email that he has used for registering
                             * */

                            val intent =
                                Intent(this@MainActivity, HomeActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            intent.putExtra(
                                "user_id",
                                FirebaseAuth.getInstance().currentUser!!.uid
                            )
                            intent.putExtra("email_id", email)
                            startActivity(intent)
                            finish()
                        } else {
                            // If the login is not successful then show error message
                            Toast.makeText(
                                this@MainActivity,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
        }
    }