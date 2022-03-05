package com.babuckman.ispacekotlin.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityMainBinding
import com.babuckman.ispacekotlin.myapplication.ui.HomeActivity

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
    }

    fun loginNow() {
        username = binding.edtUsername.text.toString()
        password = binding.editTextPassword.text.toString()

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
        }else{
            if(username == "Ben" && password == "123"){
                var intent = Intent(this@MainActivity, HomeActivity::class.java)
                intent.putExtra("username",username)

                startActivity(intent)
                }

            }
        }
}