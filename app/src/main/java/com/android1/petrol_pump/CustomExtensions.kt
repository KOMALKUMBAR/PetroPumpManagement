package com.android1.petrol_pump

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.google.gson.Gson
import com.shuhart.stepview.BuildConfig

fun View.hide(){
    visibility = View.GONE
}

fun View.show(){
    visibility = View.VISIBLE
}

fun TextView.changeColor(color : Int){
    setTextColor(ResourcesCompat.getColor(resources,color,null))
}

fun View.changeBackgroundColor(color: Int){
    setBackgroundColor(ResourcesCompat.getColor(resources,color,null))
}

fun Any.logToJson(prefix : String = ""){
    if(BuildConfig.DEBUG)
        Gson().toJson(this).log(prefix)
}

fun String.log(prefix : String = ""){
    if(BuildConfig.DEBUG){
        Log.d("$prefix Log",this)
    }
}

fun View.isVisible() : Boolean{
    return this.visibility == View.VISIBLE
}