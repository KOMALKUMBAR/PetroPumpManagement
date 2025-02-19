package com.android1.petrol_pump

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.android1.petrol_pump.ui.bill_invoice.UpdatedBillInvoiceActivity

class HomeActivity : AppCompatActivity() {
    lateinit var cardView: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val Emaster = findViewById<CardView>(R.id.Emaster)
        Emaster.setOnClickListener() {
            val i = Intent(this, EmployeeActivity::class.java)
            startActivity(i) }

        val itemMaster=findViewById<CardView>(R.id.itemaster)
        itemMaster.setOnClickListener()
        {
            val intent =Intent(this,Item_MasterActivity::class.java)
            startActivity(intent)
        }
       val Nmaster =findViewById<CardView>(R.id.Nmaster)
        Nmaster.setOnClickListener(){
            val intent1 =Intent(this,Nozal_MasterActivity::class.java)
            startActivity(intent1)
        }

        val account=findViewById<CardView>(R.id.account)
        account.setOnClickListener()
        {
            val intent2=Intent(this,AccountActivity::class.java)
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