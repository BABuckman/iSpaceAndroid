package com.babuckman.ispacekotlin.customadapterapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.babuckman.ispacekotlin.customadapterapplication.Model.ImageFromNet
import com.babuckman.ispacekotlin.customadapterapplication.R
import com.bumptech.glide.Glide

class ImageFromNetAdapter(private val context: Context, private val imageList: List<ImageFromNet>):RecyclerView.Adapter<ImageFromNetAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.card_view_layout, parent, false)
        return ImageViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imagePosition = imageList[position]

        holder.imageItem.text = imagePosition.name
        holder.description.text = imagePosition.description

        Glide
            .with(context) //pass context
            .load(imagePosition.image) //pass image url
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageURL);
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
    class ImageViewHolder(ImageItem: View):RecyclerView.ViewHolder(ImageItem){
        val imageURL: ImageView = ImageItem.findViewById(R.id.imageView)
        val imageItem: TextView = ImageItem.findViewById(R.id.itemName)
        val description:TextView = ImageItem.findViewById(R.id.description)
    }
}