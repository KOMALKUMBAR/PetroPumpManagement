package com.android1.petrol_pump

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Nozal_MasterActivity : AppCompatActivity() {
    lateinit var floatingActionButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nozalmaster)
        val fabAddNozal =findViewById<FloatingActionButton>(R.id.fabAddNozal)
        fabAddNozal.setOnClickListener(){
            val intent=Intent(this,Add_NozalMasterActivity::class.java)
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