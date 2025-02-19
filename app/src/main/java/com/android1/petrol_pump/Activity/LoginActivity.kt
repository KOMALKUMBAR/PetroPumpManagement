package com.android1.petrol_pump.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android1.petrol_pump.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val Username=findViewById<TextInputEditText>(R.id.username)
            val password =findViewById<TextInputEditText>(R.id.password)
            val button =findViewById<Button>(R.id.nextButton)
            button.setOnClickListener() {
                val name= Username.text.toString()
                val Password = password.text.toString()

                if (name.isEmpty())
            else if (Password.isEmpty()){
                password.error="Enter password"
                return@setOnClickListener
            }
            else
            {
                Toast.makeText(this,"Hey $name!login Successful..", Toast.LENGTH_SHORT).show()
                val i =Intent(this, HomeActivity::class.java)
                startActivity(i)
            }

         }



    }




}