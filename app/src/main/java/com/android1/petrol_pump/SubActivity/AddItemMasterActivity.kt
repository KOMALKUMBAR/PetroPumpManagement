package com.android1.petrol_pump.SubActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android1.petrol_pump.Activity.Item_MasterActivity
import com.android1.petrol_pump.R
import com.android1.petrol_pump.model.ItemMasterDataClass
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddItemMasterActivity : AppCompatActivity() {

    private lateinit var etItemName: TextInputEditText
    private lateinit var etPrice: TextInputEditText
    private lateinit var etPurchaseRate: TextInputEditText
    private lateinit var btnSubmit: Button
    private lateinit var database: DatabaseReference
    private var itemId: String? = null
    private var isEditing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        // Back Button Functionality
        val addItemBackBtn = findViewById<ImageView>(R.id.ivBack)
        addItemBackBtn.setOnClickListener {
            finish()
        }

        // Initialize UI Components
        etItemName = findViewById(R.id.etItemName)
        etPrice = findViewById(R.id.etPrice)
        etPurchaseRate = findViewById(R.id.etPurchaseRate)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Firebase Database Reference
        database = FirebaseDatabase.getInstance().getReference("Items")

        // Check if Editing Mode
        isEditing = intent.getBooleanExtra("isEditing", false)
        if (isEditing) {
            itemId = intent.getStringExtra("itemId")
            etItemName.setText(intent.getStringExtra("itemName"))
            etPrice.setText(intent.getStringExtra("price"))
            etPurchaseRate.setText(intent.getStringExtra("purchaseRate"))
            btnSubmit.text = "Update Item"
        }

        // Submit Button Click Listener
        btnSubmit.setOnClickListener {
            if (isEditing) {
                updateItemInFirebase()
            } else {
                saveDataToFirebase()
            }
        }
    }

    private fun saveDataToFirebase() {
        val itemName = etItemName.text?.trim().toString()
        val price = etPrice.text?.trim().toString()
        val purchaseRate = etPurchaseRate.text?.trim().toString()

        if (itemName.isEmpty() || price.isEmpty() || purchaseRate.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val id = database.push().key ?: return
        val item = ItemMasterDataClass(id, itemName, price, purchaseRate)

        database.child(id).setValue(item).addOnSuccessListener {
            Toast.makeText(this, "Item Added Successfully!", Toast.LENGTH_SHORT).show()
            navigateBack()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to add item!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateItemInFirebase() {
        val itemName = etItemName.text?.trim().toString()
        val price = etPrice.text?.trim().toString()
        val purchaseRate = etPurchaseRate.text?.trim().toString()

        if (itemId == null || itemName.isEmpty() || price.isEmpty() || purchaseRate.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val updatedItem = ItemMasterDataClass(itemId!!, itemName, price, purchaseRate)
        database.child(itemId!!).setValue(updatedItem).addOnSuccessListener {
            Toast.makeText(this, "Item Updated Successfully!", Toast.LENGTH_SHORT).show()
            navigateBack()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to update item!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateBack() {
        startActivity(Intent(this, Item_MasterActivity::class.java))
        finish()
    }
}
