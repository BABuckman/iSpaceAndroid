package com.babuckman.ispacekotlin.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityHomeBinding
import com.babuckman.ispacekotlin.myapplication.databinding.ActivityMainBinding
import com.babuckman.ispacekotlin.myapplication.ui.HomeActivity

class MainActivity : AppCompatActivity() {
    //Variables
    lateinit var binding:ActivityMainBinding

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
        val username:String = binding.edtUsername.text.toString()
        val password:String = binding.editTextTextPassword.text.toString()

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
        }else{
            if(username == "Ben" && password == "123"){
                intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("username",username)

                startActivity(intent)
                }

            }
        }
}