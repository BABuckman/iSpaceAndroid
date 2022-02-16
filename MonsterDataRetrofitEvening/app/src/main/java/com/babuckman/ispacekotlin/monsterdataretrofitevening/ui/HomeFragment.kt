package com.babuckman.ispacekotlin.monsterdataretrofitevening.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.babuckman.ispacekotlin.monsterdataretrofitevening.data.MonsterData
import com.babuckman.ispacekotlin.monsterdataretrofitevening.data.MonsterRepository
import com.babuckman.ispacekotlin.monsterdataretrofitevening.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.monsterData.observe(viewLifecycleOwner, {
            val str = StringBuilder()
            for (monsterD in it){
                str.append(monsterD.monsterName + "\n")
            }
            binding.tvNames.text = str
        })

        return binding.root
    }
}