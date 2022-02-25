package com.babuckman.ispacekotlin.monsterdataretrofitevening.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.babuckman.ispacekotlin.monsterdataretrofitevening.R
import com.babuckman.ispacekotlin.monsterdataretrofitevening.data.MonsterData
import com.bumptech.glide.Glide

class MonsterAdapter(val context:Context,
                     val monsterList: List<MonsterData>,
                     val handleMonsterItem:HandleMonsterItem):
    RecyclerView.Adapter<MonsterAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.monster_griditems, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monster = monsterList[position]
        holder.monsterName.text = monster.monsterName
        holder.ratingBar.rating = monster.scariness.toFloat()

        //Loading the image with glide
        Glide.with(context)
            .load(monster.imageFullURL) //change this change the image size
            .into(holder.monsterImage) //holder puts the image into the view

        //Handle object click
        holder.itemView.setOnClickListener {
            handleMonsterItem.monsterClicked(monster)
        }
    }

    override fun getItemCount(): Int {
        return monsterList.size
    }

    inner class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        val monsterName: TextView = ItemView.findViewById(R.id.nameText)
        val monsterImage: ImageView = ItemView.findViewById(R.id.monsterImage)
        val ratingBar: RatingBar = ItemView.findViewById(R.id.ratingBar)
    }

    interface HandleMonsterItem{
        fun monsterClicked(monster: MonsterData)
    }
}