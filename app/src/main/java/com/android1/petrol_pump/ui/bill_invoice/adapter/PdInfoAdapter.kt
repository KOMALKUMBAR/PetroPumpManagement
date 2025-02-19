package com.android1.petrol_pump.ui.bill_invoice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.android1.petrol_pump.ui.bill_invoice.AdapterCallbackInterface
import com.android1.petrol_pump.model.PdInfoFormData
import com.android1.petrol_pump.R
import com.google.android.material.textfield.TextInputLayout

class PdInfoAdapter(private val callback: AdapterCallbackInterface) : RecyclerView.Adapter<PdInfoAdapter.ViewHolder>() {

    private val items = mutableListOf<PdInfoFormData>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Get references to views in the item layout
      //  val editTextName: EditText = itemView.findViewById(R.id.editTextName)
      //  val editTextEmail: EditText = itemView.findViewById(R.id.editTextEmail)
        val buttonSave: Button = itemView.findViewById(R.id.button_save)
        val buttonClear: Button = itemView.findViewById(R.id.button_clear)
        val buttonEdit: ImageButton = itemView.findViewById(R.id.editButton)
        val buttonDelete: ImageButton = itemView.findViewById(R.id.deleteButton)
        val atvShift: AutoCompleteTextView = itemView.findViewById(R.id.atv_shift)
        val atvNozal: AutoCompleteTextView = itemView.findViewById(R.id.atv_nozal)
        val tilClosingMeter: TextInputLayout = itemView.findViewById(R.id.til_closing_meter)
        val tilOpeningMeter: TextInputLayout = itemView.findViewById(R.id.til_opening_meter)
        val tilTotalLitre: TextInputLayout = itemView.findViewById(R.id.til_total_litre)
        val tilTesting: TextInputLayout = itemView.findViewById(R.id.til_testing)
        val tilTotal: TextInputLayout = itemView.findViewById(R.id.til_total)
        val tilRate: TextInputLayout = itemView.findViewById(R.id.til_rate)
        val tilTotalAmount: TextInputLayout = itemView.findViewById(R.id.til_total_amount)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pdinfo_list_item, parent, false)
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
            holder.atvNozal.isEnabled  =false
            holder.atvShift.isEnabled =false
            holder.tilClosingMeter.isEnabled =false
            holder.tilOpeningMeter.isEnabled =false
            holder.tilTotalLitre.isEnabled =false
            holder.tilTesting.isEnabled =false
            holder.tilTotal.isEnabled =false
            holder.tilRate.isEnabled =false
            holder.tilTotalAmount.isEnabled =false
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

    fun addItem(formData: PdInfoFormData) {
        items.add(formData)
        notifyItemInserted(items.size - 1)
    }
}