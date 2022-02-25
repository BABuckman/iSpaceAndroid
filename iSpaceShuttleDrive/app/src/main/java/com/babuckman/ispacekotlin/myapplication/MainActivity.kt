package com.babuckman.ispacekotlin.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.babuckman.ispacekotlin.myapplication.ui.HomeActivity

class MainActivity : AppCompatActivity() {
    //Instance Variables
    lateinit var username:EditText
    lateinit var password:EditText
    lateinit var login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instantiate variables
        username = findViewById(R.id.edtUsername)
        password = findViewById(R.id.editTextTextPassword)
        login = findViewById(R.id.btnLogin)

        login.setOnClickListener{
            //Log.i("TAG", "Login page worked")
            loginNow()
        }
    }

    fun loginNow() {
        val name:String = username.toString()
        val passwordString:String = password.toString()

        if(name.isEmpty() || passwordString.isEmpty()){
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
        }else{
           // if(name == "Ben" && passwordString == "123"){
                intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            //}

        }
    }
}