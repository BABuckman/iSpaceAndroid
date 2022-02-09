package com.babuckman.ispacekotlin.fetchstaticdatademo.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.babuckman.ispacekotlin.fetchstaticdatademo.R
import com.babuckman.ispacekotlin.fetchstaticdatademo.util.FileHelper

class HomeViewModel(app:Application) : AndroidViewModel(app) {
    init {
        val text = FileHelper.getTextFromResources(app, R.raw.learners)
        // val text = FileHelper.getTextFromAssets(app, "learners.json")
        Log.d("Data", text)
        //parseText(text)
    }
}