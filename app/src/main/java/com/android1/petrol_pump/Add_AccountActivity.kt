package com.android1.petrol_pump

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Add_AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_account)
        val AddAcoundbackbtn =findViewById<ImageView>(R.id.AddAcoundbackbtn)
        AddAcoundbackbtn.setOnClickListener(){
            val intent=Intent(this,AccountActivity::class.java)
            startActivity(intent)
        }
    }
}