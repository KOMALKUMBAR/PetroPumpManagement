package com.android1.petrol_pump.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android1.petrol_pump.R
import com.android1.petrol_pump.SubActivity.AddNozalMasterActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NozalMasterActivity : AppCompatActivity() {
    lateinit var floatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nozalmaster)
        val fabAddNozal =findViewById<FloatingActionButton>(R.id.fabAddNozal)
        fabAddNozal.setOnClickListener(){
            val intent=Intent(this, AddNozalMasterActivity::class.java)
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