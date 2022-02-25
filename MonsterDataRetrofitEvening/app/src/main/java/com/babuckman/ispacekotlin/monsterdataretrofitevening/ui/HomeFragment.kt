package com.babuckman.ispacekotlin.monsterdataretrofitevening.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.babuckman.ispacekotlin.monsterdataretrofitevening.R
import com.babuckman.ispacekotlin.monsterdataretrofitevening.data.MonsterData
import com.babuckman.ispacekotlin.monsterdataretrofitevening.databinding.FragmentHomeBinding
import com.babuckman.ispacekotlin.monsterdataretrofitevening.util.MonsterAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment(), MonsterAdapter.HandleMonsterItem {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.monsterData.observe(viewLifecycleOwner, {

            var adapter = MonsterAdapter(requireContext(), it, this)
            binding.recyclerview.adapter = adapter
        })

        return binding.root
    }

    override fun monsterClicked(monster: MonsterData) {
        requireActivity().supportFragmentManager.commit {
            val bottomNavigationView: BottomNavigationView =
                requireActivity().findViewById(R.id.bottom_nav)
            bottomNavigationView.visibility = View.INVISIBLE

            replace<ProfileFragment>(R.id.container, null, null)
        }

        viewModel.selectedMonster.value = listOf(monster)
        val navController: NavController = Navigation.findNavController(
            requireActivity(), R.id.container)
        navController.navigate(R.id.action_homeFragment_to_profileFragment)
    }
}