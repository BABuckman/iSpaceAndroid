package com.babuckman.ispacekotlin.monsterdataretrofitevening.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.babuckman.ispacekotlin.monsterdataretrofitevening.R
import com.babuckman.ispacekotlin.monsterdataretrofitevening.databinding.ActivityMainBinding
import com.babuckman.ispacekotlin.monsterdataretrofitevening.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentProfileBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        setHasOptionsMenu(true)
        navController = Navigation.findNavController(
            requireActivity(), R.id.container
        )


        viewModel.selectedMonster

        return binding.root
    }
}