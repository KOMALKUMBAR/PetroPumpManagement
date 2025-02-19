package com.android1.petrol_pump.ui.bill_invoice.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android1.petrol_pump.JsonData
import com.android1.petrol_pump.R

class EmployeAdapter(val context:Activity, val productJsonDatataArrayList:List<JsonData>):
    RecyclerView.Adapter<EmployeAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val itemView  = LayoutInflater.from(context).inflate(R.layout.listview,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        val currentItem = productJsonDatataArrayList[position]
        holder.EmpName.text=currentItem.title
        holder.EmpId.text=currentItem.brand
        holder.EmpMobile.text=currentItem.description
        holder.EmpGender.text=currentItem.brand
    }

    override fun getItemCount(): Int
    {
        return productJsonDatataArrayList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {  val EmpName:TextView
        val EmpId:TextView
        val EmpMobile:TextView
        val EmpGender:TextView
        init {
            EmpName=itemView.findViewById(R.id.EmpName)
            EmpId=itemView.findViewById(R.id.EmpId)
            EmpMobile =itemView.findViewById(R.id.EmpMobile)
            EmpGender =itemView.findViewById(R.id.EmpGender)
        }

    }
    }
