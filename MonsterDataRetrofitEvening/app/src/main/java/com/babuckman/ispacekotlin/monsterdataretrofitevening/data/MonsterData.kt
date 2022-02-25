package com.babuckman.ispacekotlin.monsterdataretrofitevening.data

import com.babuckman.ispacekotlin.monsterdataretrofitevening.util.IMAGE_BASE_URL

data class MonsterData(
    val imageFile:String,
    val monsterName:String,
    val caption:String,
    val description:String,
    val price:Double,
    val scariness:Int
){
    val imageURl
    get() = "$IMAGE_BASE_URL/$imageFile.webp"
    val imageFullURL
    get() = "$IMAGE_BASE_URL/${imageFile}_tn.webp"

}
