package com.babuckman.ispacekotlin.monsterdataretrofitevening.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.babuckman.ispacekotlin.monsterdataretrofitevening.data.MonsterRepository

class HomeViewModel(app: Application): AndroidViewModel(app) {
    val dataRepo = MonsterRepository(app)
    val monsterData = dataRepo.monsterData
}