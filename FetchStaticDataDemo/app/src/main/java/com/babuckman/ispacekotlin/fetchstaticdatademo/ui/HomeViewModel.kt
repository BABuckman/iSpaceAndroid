package com.babuckman.ispacekotlin.fetchstaticdatademo.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.babuckman.ispacekotlin.fetchstaticdatademo.data.LearnersRepository

class HomeViewModel(app:Application) : AndroidViewModel(app) {
    private val dataRepo = LearnersRepository()
    init {
        val learnersData = dataRepo.getLearnersData(app)

        for (learners in learnersData){
            Log.i("DATA","${learners.first_name}${learners.last_name}(\$${learners.gender})")
        }
    }
/*
    init {
        val text = FileHelper.getTextFromResources(app, R.raw.learners)
        // val text = FileHelper.getTextFromAssets(app, "learners.json")
        Log.d("Data", text)
        //parseText(text)
    }
     */
}