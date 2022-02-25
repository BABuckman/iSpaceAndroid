package com.babuckman.ispacekotlin.monsterdataretrofitevening

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.babuckman.ispacekotlin.monsterdataretrofitevening.databinding.ActivityMainBinding
import com.babuckman.ispacekotlin.monsterdataretrofitevening.ui.HomeFragment
import com.babuckman.ispacekotlin.monsterdataretrofitevening.ui.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //bind fragment object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNav.visibility = View.VISIBLE

        navController = Navigation.findNavController(this@MainActivity, R.id.container)

        supportFragmentManager.commit {
            add<HomeFragment>(R.id.container, null, null)
        }

        binding.bottomNav.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.home -> goToHome()
                R.id.home -> goToProfile()
                else -> false
            }
        }
    }

    private fun goToProfile():Boolean {
        supportFragmentManager.commit {
            replace<ProfileFragment>(R.id.container, null, null)
        }
        return true
    }

    private fun goToHome():Boolean {
        supportFragmentManager.commit {
            replace<HomeFragment>(R.id.container, null, null)
        }
        return true
    }
}