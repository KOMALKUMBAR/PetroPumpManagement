package com.android1.petrol_pump.SubActivity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android1.petrol_pump.Activity.Item_MasterActivity
import com.android1.petrol_pump.R

class AddItemMasterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        val AddItembackbtn =findViewById<ImageView>(R.id.ivBack)
        AddItembackbtn.setOnClickListener() {
            val i = Intent(this, Item_MasterActivity::class.java)
            startActivity(i)
        }
    }
}