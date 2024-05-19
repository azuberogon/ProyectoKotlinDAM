package com.example.aguas.Layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.aguas.R

/**
 *
 *
 *
 *
 * @autor Aitor
 * */
class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
       /* val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val loremIpsum = resources.getString(R.string.sample_contract_text)
        val loremIpsumArray = loremIpsum.split("\n").toTypedArray()

        val adapter = AdapterText(loremIpsumArray)
        recyclerView.adapter = adapter
    */


        val scrollViewText = findViewById<TextView>(R.id.loremimpsun)
        val loremIpsum = resources.getString(R.string.sample_contract_text)
        scrollViewText.text = loremIpsum

    }
}