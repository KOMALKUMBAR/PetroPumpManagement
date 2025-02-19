package com.android1.petrol_pump.SubActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android1.petrol_pump.Activity.EmployeeActivity
import com.android1.petrol_pump.R
import com.google.android.material.textfield.TextInputEditText

class AddEmployeeActivity : AppCompatActivity() {
    lateinit var text: TextInputEditText
    lateinit var button: Button
    var isAllFieldsChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)
        val Ename=findViewById<TextInputEditText>(R.id.Ename)
        val EmployeeId =findViewById<TextInputEditText>(R.id.EmployeeId)
        val MbleNo=findViewById<TextInputEditText>(R.id.MbleNo)
        val male=findViewById<CheckBox>(R.id.male)
        val Fmale = findViewById<CheckBox>(R.id.Fmale)
        val Sbutton=findViewById<Button>(R.id.save)
        val AddEmploybackbtn =findViewById<ImageView>(R.id.ivBack)
        AddEmploybackbtn.setOnClickListener() {
            val i = Intent(this, EmployeeActivity::class.java)
            startActivity(i)
        }
        // form validation  code
        Sbutton.setOnClickListener() {

            val Empname = Ename.text.toString().trim()
            val EmpId = EmployeeId.text.toString().trim()
            val EmpMbl = MbleNo.text.toString().trim()
            val Emale = male.text.toString().trim()
            val Efemale = Fmale.text.toString().trim()
            if(Empname.isEmpty()){
                Ename.error="Enter Employee Name"
                return@setOnClickListener
            }
            if(EmpId.isEmpty())
            {
                EmployeeId.error="Enter Employee Id"
                return@setOnClickListener
            }
            else if (EmpMbl.length <=10)
            {
               MbleNo.error="Enter Mobile No"
               return@setOnClickListener
            }
           else if (Emale.isEmpty())
            {
                male.error="select Gender"
                return@setOnClickListener
            }
            else if (Efemale.isEmpty())
            {
                Fmale.error="select Gender"
               return@setOnClickListener
            }
            else{
                Toast.makeText(applicationContext,"Data insert Successfully",Toast.LENGTH_LONG).show()
            }
            val intent =Intent(this@AddEmployeeActivity, EmployeeActivity::class.java)
            startActivity(intent)
        }

        }


}





