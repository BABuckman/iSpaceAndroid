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

        /*
        binding.navBottom.setOnNavigationItemReselectedListener{
            item -> when(item.itemId){
                R.id.home -> goToHome()
            R.id.profile -> goToProfile()
            R.id.camera -> goToCamera()
            R.id.shop -> goToShop()
            else -> false
            }
        }

         */
    }

    private fun goToShop() {
        TODO("Not yet implemented")
    }

    private fun goToCamera() {
        TODO("Not yet implemented")
    }

    private fun goToProfile() {
        TODO("Not yet implemented")
    }

    private fun goToHome() {
        TODO("Not yet implemented")
    }
}