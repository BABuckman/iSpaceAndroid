package com.babuckman.ispacekotlin.displayfruit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var listview:ListView
    private val fruitNames = arrayOf("banana", "grape", "guava", "oranges", "watermelon", "mango")
    private val friutImages = arrayOf(
        R.drawable.banana ,
        R.drawable.grapes ,
        R.drawable.guava ,
        R.drawable.orange ,
        R.drawable.watermelon,
        R.drawable.mango
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview = findViewById(R.id.listview)

        var list = ArrayList<HashMap<String, Any>>()

        for (i in fruitNames.indices) {
            val map = HashMap<String, Any>()
            //Data entry in HaspMap
            map["fruitnames"] = fruitNames[i]
            map["images"] = friutImages[i]
            //Adding the hashmap to the arraylist
                list.add(map)
        }

        val from = arrayOf("friutname", "friutimages")
        val to = intArrayOf(R.id.textView, R.id.imageView)

        var simpleAdapter = SimpleAdapter(this, list, R.layout.list_row_items, from, to)

        listview.adapter = simpleAdapter
    }
}