package com.android1.petrol_pump.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android1.petrol_pump.ApiInterfaceModel.ApiInterface
import com.android1.petrol_pump.Mydata
import com.android1.petrol_pump.R
import com.android1.petrol_pump.SubActivity.AddEmployeeActivity
import com.android1.petrol_pump.ui.bill_invoice.adapter.EmployeAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EmployeeActivity : AppCompatActivity() {
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: EmployeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        fabAdd.setOnClickListener(){
            val i=Intent(this, AddEmployeeActivity::class.java)
        startActivity(i)}
        //back buttton
        var btnBack =findViewById<ImageView>(R.id.ivBack)
        btnBack.setOnClickListener(){
            val i=Intent(this, HomeActivity::class.java)
            startActivity(i)
        }


        val recyclerView=findViewById<RecyclerView>(R.id.recyclerview)
        val retrofitBuilder =Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData=retrofitBuilder.getJsonData()
        retrofitData.enqueue(object : Callback<Mydata?>
        {
            override fun onResponse(call: Call<Mydata?>, response: Response<Mydata?>) {
                val  responese =response.body()
                val JsonData=responese?.products!!
                myAdapter = EmployeAdapter(this@EmployeeActivity, JsonData)
                recyclerView.adapter=myAdapter
                recyclerView.layoutManager= LinearLayoutManager(this@EmployeeActivity)
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Mydata?>, t: Throwable) {
                val d = Log.d("employee Activity","Failed:"+t.message)

            }

        })
    }
}