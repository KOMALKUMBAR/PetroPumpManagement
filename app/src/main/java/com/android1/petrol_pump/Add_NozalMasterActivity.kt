package com.android1.petrol_pump

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Add_NozalMasterActivity : AppCompatActivity() {
    lateinit var autoCompleteTextView: AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nozal)
        val AddNozalMasterbackbtn =findViewById<ImageView>(R.id.AddNozalMasterbackbtn)
        AddNozalMasterbackbtn.setOnClickListener() {
            val i = Intent(this,Nozal_MasterActivity::class.java)
            startActivity(i)
        }
        val items = listOf("Machine No1", "Machine No2")
        val autoComplete = findViewById<AutoCompleteTextView>(R.id.MachineName)
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener() { adapterView, view, i, l ->
                val itemSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "machine: $itemSelected", Toast.LENGTH_LONG).show()
            }
        val item = listOf("Petrol", "Dizel", "Power")
        val autoproduct = findViewById<AutoCompleteTextView>(R.id.autoproduct)
        val Adapter = ArrayAdapter(this, R.layout.list_item, item)
        autoproduct.setAdapter(Adapter)
        autoproduct.onItemClickListener = AdapterView.OnItemClickListener() { adapterView, view, i, l ->
                val itemSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "product: $itemSelected", Toast.LENGTH_LONG).show()
            }
        val macName = findViewById<AutoCompleteTextView>(R.id.MachineName)
        val nozal = findViewById<TextInputEditText>(R.id.Nozal)
        val autoProduct = findViewById<AutoCompleteTextView>(R.id.autoproduct)
        val machiname = macName.text.toString().trim()
        val ENozal = nozal.text.toString().trim()
        val product = autoProduct.text.toString().trim()
        val NozalSave = findViewById<Button>(R.id.save)
        NozalSave.setOnClickListener() {

            if (machiname.isEmpty()) {
                macName.error = "Enter Machine Name"
                return@setOnClickListener
            }

            if (product.isEmpty()) {
                autoProduct.error = "Enter Product name"
                return@setOnClickListener
            }
            else {
                Toast.makeText(applicationContext, "Data insert Successfully", Toast.LENGTH_LONG)
                    .show()
            }

        }

    }
}



