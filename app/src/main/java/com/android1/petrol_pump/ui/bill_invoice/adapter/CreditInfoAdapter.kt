package com.android1.petrol_pump.ui.bill_invoice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.android1.petrol_pump.ui.bill_invoice.AdapterCallbackInterface
import com.android1.petrol_pump.R
import com.android1.petrol_pump.model.CreditInfoFormData
import com.google.android.material.textfield.TextInputLayout

class CreditInfoAdapter(private val callback: AdapterCallbackInterface) : RecyclerView.Adapter<CreditInfoAdapter.ViewHolder>() {

    private val items = mutableListOf<CreditInfoFormData>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Get references to views in the item layout
      //  val editTextName: EditText = itemView.findViewById(R.id.editTextName)
      //  val editTextEmail: EditText = itemView.findViewById(R.id.editTextEmail)
        val buttonSave: Button = itemView.findViewById(R.id.button_save)
        val buttonClear: Button = itemView.findViewById(R.id.button_clear)
        val buttonEdit: ImageButton = itemView.findViewById(R.id.editButton)
        val buttonDelete: ImageButton = itemView.findViewById(R.id.deleteButton)
        val atvCustomer: AutoCompleteTextView = itemView.findViewById(R.id.atv_customer)
        val atvItem: AutoCompleteTextView = itemView.findViewById(R.id.atv_item)
        val tilBillNumber: TextInputLayout = itemView.findViewById(R.id.til_bill_number)
        val tilVehicalNumber: TextInputLayout = itemView.findViewById(R.id.til_vehical_number)
        val tilRate: TextInputLayout = itemView.findViewById(R.id.til_rate)
        val tilQuantity: TextInputLayout = itemView.findViewById(R.id.til_quantity)
        val tilTotal: TextInputLayout = itemView.findViewById(R.id.til_total)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.creditinfo_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.buttonEdit.visibility = View.GONE
        holder.buttonDelete.visibility = View.GONE
        val item = items[position]
        // Bind data to views
       // holder.editTextName.setText(item.name)
       // holder.editTextEmail.setText(item.email)

        // Set click listeners for save and cancel buttons
        holder.buttonSave.setOnClickListener {
            holder.buttonEdit.visibility = View.VISIBLE
            holder.buttonDelete.visibility = View.VISIBLE
            holder.atvItem.isEnabled  =false
            holder.atvCustomer.isEnabled =false
            holder.tilBillNumber.isEnabled =false
            holder.tilVehicalNumber.isEnabled =false
            holder.tilQuantity.isEnabled =false
            holder.tilTotal.isEnabled =false
            holder.tilRate.isEnabled =false
            holder.buttonSave.visibility = View.GONE
            holder.buttonClear.visibility = View.GONE

            callback.onEventTriggered(true)
        }

        holder.buttonClear.setOnClickListener {



        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(formData: CreditInfoFormData) {
        items.add(formData)
        notifyItemInserted(items.size - 1)
    }
}