package com.babuckman.ispacekotlin.monsterdataretrofitevening

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.babuckman.ispacekotlin.monsterdataretrofitevening.databinding.ActivityMainBinding
import com.babuckman.ispacekotlin.monsterdataretrofitevening.ui.HomeFragment
import com.babuckman.ispacekotlin.monsterdataretrofitevening.ui.ProfileFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //bind fragment object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

    private fun goToProfile() {
        supportFragmentManager.commit {
            replace<ProfileFragment>(R.id.container, null, null)
        }
    }

    private fun goToHome() {
        supportFragmentManager.commit {
            replace<HomeFragment>(R.id.container, null, null)
        }
    }
}