package com.babuckman.ispacekotlin.customadapterapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.babuckman.ispacekotlin.customadapterapplication.Adapter.ImageFromNetAdapter
import com.babuckman.ispacekotlin.customadapterapplication.Model.ImageFromNet

class MainActivity : AppCompatActivity() {
    //Create an instance of the recyclerView
    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //refer to the instance of the view object
        recyclerView = findViewById(R.id.recyclerview)
        //this creates a layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        //data
        val imageFromNet = ArrayList<ImageFromNet>()
        imageFromNet.add(ImageFromNet("https://images.pexels.com/photos/145939/pexels-photo-145939.jpeg?auto=compress&cs=tinysrgb&h=650&w=940","Tiger","A tiger is a jungle animal"))
        imageFromNet.add(ImageFromNet("https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Cat","Cats are adorable."))
        imageFromNet.add(ImageFromNet("https://images.pexels.com/photos/40984/animal-ara-macao-beak-bird-40984.jpeg?auto=compress&cs=tinysrgb&h=650&w=940","Parrot","Parrots can repeat what you say"))
        imageFromNet.add(ImageFromNet("https://images.pexels.com/photos/247502/pexels-photo-247502.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Lion","Lion is king of the jungle"))
        imageFromNet.add(ImageFromNet("","",""))
        imageFromNet.add(ImageFromNet("","",""))
        imageFromNet.add(ImageFromNet("","",""))
        imageFromNet.add(ImageFromNet("","",""))
        imageFromNet.add(ImageFromNet("","",""))

        val adapter = ImageFromNetAdapter(this, imageFromNet)
        recyclerView.adapter = adapter
    }
}