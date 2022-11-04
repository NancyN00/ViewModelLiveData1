package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass : ViewModel() {
   // var count = 0
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    //function to increase the value by one

    fun updateCount(){
        //use increment operator
       // ++count

        //add safe call operator to avoid null operator
        count.value = (count.value)?.plus(1)
        //mutable live data is live data
    }
}