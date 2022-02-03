package com.babuckman.ispacekotlin.webappsample.Login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.babuckman.ispacekotlin.webappsample.R

class Login:AppCompatActivity() {
    private lateinit var username:EditText
    private lateinit var password: EditText
    private lateinit var login:Button
    private lateinit var cancel:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        cancel = findViewById(R.id.Cancel)
        //Write implementation for login
        login.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                if(username.text.equals("ben") && password.text.equals("1234")){
                    val message:String = "Redirecting..."
                    Toast.makeText(this@Login, message, Toast.LENGTH_SHORT)
                }
            }
        })
        //write implementation for cancel
        cancel.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                finish()
            }
        })
    }

}
