package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    var count = 0
    //reference variable for the ViewModel object
    private lateinit var viewModel:ViewModelClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //because we are inside the main activity, use this to refer as the recycle owner
        viewModel = ViewModelProvider(this).get(ViewModelClass::class.java)
        val textview = findViewById<TextView>(R.id.tvcount)
        val button = findViewById<Button>(R.id.btncount)

       // textview.text = count.toString()
        viewModel.count.observe(this, Observer {
            textview.text = it.toString()
        })

        //use view model count values
       // textview.text = viewModel.count.toString()
        button.setOnClickListener{
            viewModel.updateCount()

        }

    }
}