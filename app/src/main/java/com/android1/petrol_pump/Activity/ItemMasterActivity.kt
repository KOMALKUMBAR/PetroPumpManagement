package com.android1.petrol_pump.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android1.petrol_pump.R
import com.android1.petrol_pump.SubActivity.AddItemMasterActivity
import com.android1.petrol_pump.adapter.ItemMasterAdapter
import com.android1.petrol_pump.model.ItemMasterDataClass
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Item_MasterActivity : AppCompatActivity() {
    lateinit var floatingActionButton: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: ArrayList<ItemMasterDataClass>
    private lateinit var adapter: ItemMasterAdapter
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_master)
        val fabAddItem = findViewById<FloatingActionButton>(R.id.fabAddItem)
        fabAddItem.setOnClickListener(){
            val intent=Intent(this, AddItemMasterActivity::class.java)
            startActivity(intent)
        }
        //back buttton
        var btnBack =findViewById<ImageView>(R.id.ivBack)
        btnBack.setOnClickListener(){
            val i=Intent(this, HomeActivity::class.java)
            startActivity(i)
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemList = ArrayList()
        adapter = ItemMasterAdapter(this,itemList)
        recyclerView.adapter = adapter

        database = FirebaseDatabase.getInstance().getReference("Items")

        fetchItemsFromFirebase()
    }

    private fun fetchItemsFromFirebase() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                itemList.clear()
                for (dataSnapshot in snapshot.children) {
                    val item = dataSnapshot.getValue(ItemMasterDataClass::class.java)
                    if (item != null) {
                        itemList.add(item)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Item_MasterActivity, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}



