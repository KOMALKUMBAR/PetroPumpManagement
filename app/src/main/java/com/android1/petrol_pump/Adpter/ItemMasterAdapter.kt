package com.android1.petrol_pump.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android1.petrol_pump.R
import com.android1.petrol_pump.SubActivity.AddItemMasterActivity
import com.android1.petrol_pump.model.ItemMasterDataClass
import com.google.firebase.database.FirebaseDatabase

class ItemMasterAdapter(
    private val context: Context,
    private val itemList: MutableList<ItemMasterDataClass>
) : RecyclerView.Adapter<ItemMasterAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemName: TextView = itemView.findViewById(R.id.tvItemName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvPurchaseRate: TextView = itemView.findViewById(R.id.tvPurchaseRate)
        val btnEdit: ImageView = itemView.findViewById(R.id.btnEdit)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemmaster_item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.tvItemName.text = "Item: ${item.itemName}"
        holder.tvPrice.text = "Price: ${item.price}"
        holder.tvPurchaseRate.text = "Purchase Rate: ${item.purchaseRate}"

        // Edit Button Click: Open Edit Page
        holder.btnEdit.setOnClickListener {
            val intent = Intent(context, AddItemMasterActivity::class.java).apply {
                putExtra("itemId", item.id)
                putExtra("itemName", item.itemName)
                putExtra("price", item.price)
                putExtra("purchaseRate", item.purchaseRate)
                putExtra("isEditing", true) // Flag to indicate edit mode
            }
            context.startActivity(intent)
        }

        // Delete Button Click: Delete from Firebase and RecyclerView
        holder.btnDelete.setOnClickListener {
            deleteItemFromFirebase(item.id, position)
        }
    }

    override fun getItemCount(): Int = itemList.size

    private fun deleteItemFromFirebase(itemId: String, position: Int) {
        val databaseRef = FirebaseDatabase.getInstance().getReference("Items")
        databaseRef.child(itemId).removeValue().addOnSuccessListener {
            Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show()
            itemList.removeAt(position)
            notifyDataSetChanged() // Fixes issue when deleting last item
        }.addOnFailureListener {
            Toast.makeText(context, "Failed to Delete", Toast.LENGTH_SHORT).show()
        }
    }
}
