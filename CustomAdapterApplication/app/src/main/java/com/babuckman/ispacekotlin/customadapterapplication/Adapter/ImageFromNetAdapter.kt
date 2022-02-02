package com.babuckman.ispacekotlin.customadapterapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.babuckman.ispacekotlin.customadapterapplication.Model.ImageFromNet
import com.babuckman.ispacekotlin.customadapterapplication.R

class ImageFromNetAdapter(private val context: Context, private val imageList: List<ImageFromNet>):RecyclerView.Adapter<ImageFromNetAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.card_view_layout, parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
    class ImageViewHolder(ImageItem: View):RecyclerView.ViewHolder(ImageItem){

    }
}