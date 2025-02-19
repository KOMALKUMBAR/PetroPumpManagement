package com.android1.petrol_pump

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Add_EmployeeActivity : AppCompatActivity() {
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
        val AddEmploybackbtn =findViewById<ImageView>(R.id.AddEmploybackbtn)
        AddEmploybackbtn.setOnClickListener() {
            val i = Intent(this,EmployeeActivity::class.java)
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
            val intent =Intent(this@Add_EmployeeActivity,EmployeeActivity::class.java)
            startActivity(intent)
        }

        }


}





