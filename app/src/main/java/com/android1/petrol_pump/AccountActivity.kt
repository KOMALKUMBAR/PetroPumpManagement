package com.android1.petrol_pump

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AccountActivity : AppCompatActivity() {
    lateinit var floatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        val fabAddAccount = findViewById<FloatingActionButton>(R.id.fabAddAccount)
        fabAddAccount.setOnClickListener(){
            val intent = Intent(this,Add_AccountActivity::class.java)
            startActivity(intent)
        }
        //back buttton
        var btnBack =findViewById<ImageView>(R.id.backbtn)
        btnBack.setOnClickListener(){
            val i=Intent(this,HomeActivity::class.java)
            startActivity(i)
        }

    }

}