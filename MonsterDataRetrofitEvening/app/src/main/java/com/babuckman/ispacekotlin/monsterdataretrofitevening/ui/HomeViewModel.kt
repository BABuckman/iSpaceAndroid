package com.babuckman.ispacekotlin.monsterdataretrofitevening.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.babuckman.ispacekotlin.monsterdataretrofitevening.data.MonsterData
import com.babuckman.ispacekotlin.monsterdataretrofitevening.data.MonsterRepository

class HomeViewModel(app: Application): AndroidViewModel(app) {
    val dataRepo = MonsterRepository(app)
    val monsterData = dataRepo.monsterData

    val selectedMonster = MutableLiveData<List<MonsterData>>()

    //val selectedMonster = MutableLiveData<MonsterData>()
}