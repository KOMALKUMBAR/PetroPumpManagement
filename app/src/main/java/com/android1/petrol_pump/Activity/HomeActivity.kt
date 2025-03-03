package com.android1.petrol_pump.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.android1.petrol_pump.R
import com.android1.petrol_pump.ui.bill_invoice.UpdatedBillInvoiceActivity
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    lateinit var cardView: CardView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var btnBack = findViewById<ImageView>(R.id.ivBack)
        btnBack.setOnClickListener() {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        auth = FirebaseAuth.getInstance()

        val Emaster = findViewById<CardView>(R.id.Emaster)
        Emaster.setOnClickListener() {
            val i = Intent(this, EmployeeActivity::class.java)
            startActivity(i) }

        val itemMaster=findViewById<CardView>(R.id.itemaster)
        itemMaster.setOnClickListener()
        {
            val intent =Intent(this, Item_MasterActivity::class.java)
            startActivity(intent)
        }
       val Nmaster =findViewById<CardView>(R.id.Nmaster)
        Nmaster.setOnClickListener(){
            val intent1 =Intent(this, NozalMasterActivity::class.java)
            startActivity(intent1)
        }

        val account=findViewById<CardView>(R.id.account)
        account.setOnClickListener()
        {
            val intent2=Intent(this, AccountActivity::class.java)
            startActivity(intent2)
        }
        val cvBillInvoice=findViewById<CardView>(R.id.cvBillInvoice)
        cvBillInvoice.setOnClickListener() {
            //val cvBillInvoice = Intent(this, BillInvoice::class.java)
            val cvBillInvoice = Intent(this, UpdatedBillInvoiceActivity::class.java)
            startActivity(cvBillInvoice)
        }
    }

}