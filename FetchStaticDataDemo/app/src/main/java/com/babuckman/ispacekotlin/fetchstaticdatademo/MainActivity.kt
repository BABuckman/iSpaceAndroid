package com.babuckman.ispacekotlin.fetchstaticdatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.babuckman.ispacekotlin.fetchstaticdatademo.databinding.ActivityMainBinding
import com.babuckman.ispacekotlin.fetchstaticdatademo.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setting up the fragment
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add<HomeFragment>(R.id.container, null)
        }
    }
}