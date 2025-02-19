package com.android1.petrol_pump

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Add_ItemMasterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        val AddItembackbtn =findViewById<ImageView>(R.id.AddItembackbtn)
        AddItembackbtn.setOnClickListener() {
            val i = Intent(this,Item_MasterActivity::class.java)
            startActivity(i)
        }
    }
}