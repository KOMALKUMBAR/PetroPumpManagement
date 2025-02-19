package com.android1.petrol_pump.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android1.petrol_pump.R
import com.android1.petrol_pump.SubActivity.AddAccountActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AccountActivity : AppCompatActivity() {
    lateinit var floatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        val fabAddAccount = findViewById<FloatingActionButton>(R.id.fabAddAccount)
        fabAddAccount.setOnClickListener(){
            val intent = Intent(this, AddAccountActivity::class.java)
            startActivity(intent)
        }
        //back buttton
        var btnBack =findViewById<ImageView>(R.id.ivBack)
        btnBack.setOnClickListener(){
            val i=Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

    }

}