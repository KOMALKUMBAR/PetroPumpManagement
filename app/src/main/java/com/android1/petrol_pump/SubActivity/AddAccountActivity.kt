package com.android1.petrol_pump.SubActivity

import android.accounts.Account
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android1.petrol_pump.Activity.AccountActivity
import com.android1.petrol_pump.R

class AddAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_account)
        val AddAcoundbackbtn =findViewById<ImageView>(R.id.ivBack)
        AddAcoundbackbtn.setOnClickListener(){
            val intent=Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }

        val items = listOf(" Bank Account", "Expenses Account ")
        val autoComplete = findViewById<AutoCompleteTextView>(R.id.AccountType)
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener() { adapterView, view, i, l ->
                val itemSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "Account Type: $itemSelected", Toast.LENGTH_LONG).show()
            }

    }
}