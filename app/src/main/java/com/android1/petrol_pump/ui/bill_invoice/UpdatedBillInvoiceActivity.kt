package com.android1.petrol_pump.ui.bill_invoice

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android1.petrol_pump.R
import com.android1.petrol_pump.ui.bill_invoice.fragment.BankPaidFragment
import com.android1.petrol_pump.ui.bill_invoice.fragment.CreditInfoFragment
import com.android1.petrol_pump.ui.bill_invoice.fragment.OtherCreditInfoFragment
import com.android1.petrol_pump.ui.bill_invoice.fragment.PdInfoFragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class UpdatedBillInvoiceActivity : AppCompatActivity() {

    private lateinit var extendedFabNext: ExtendedFloatingActionButton
    private var currentFragment = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.activity_updated_bill_invoice)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

      //  setContentView(R.layout.activity_updated_bill_invoice)

        extendedFabNext = findViewById(R.id.efab_next)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set title and subtitle
        supportActionBar?.title = "Bill Invoice"

        // Initially show PdInfoFragment
        if (savedInstanceState == null) {
            supportActionBar?.subtitle = "Pd Info"
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, PdInfoFragment())
                .commit()
        }

        extendedFabNext.setOnClickListener {
            navigateToNextFragment()
        }

       /* // Create a new instance of the fragment
        val pdInfoFragment = PdInfoFragment()

        // Get the FragmentManager
        val fragmentManager = supportFragmentManager

        // Start a new FragmentTransaction
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Replace the fragment container with the new fragment
        fragmentTransaction.replace(R.id.fragment_container, pdInfoFragment) // Replace fragment_container with your container id

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null)

        // Commit the transaction
        fragmentTransaction.commit()*/
    }

    private fun navigateToNextFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        // Apply animations
        fragmentTransaction.setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )

        when (currentFragment) {
            0 -> {
                supportActionBar?.subtitle = "Credit Info"
                fragmentTransaction.replace(R.id.fragment_container, CreditInfoFragment())
                fragmentTransaction.addToBackStack(null)
                extendedFabNext.text = "Next"
                currentFragment++
            }
            1 -> {
                supportActionBar?.subtitle = "Other Credit Info"
                fragmentTransaction.replace(R.id.fragment_container, OtherCreditInfoFragment())
                fragmentTransaction.addToBackStack(null)
                extendedFabNext.text = "Next"
                currentFragment++
            }
            2 -> {
                supportActionBar?.subtitle = "Bank Paid"
                fragmentTransaction.replace(R.id.fragment_container, BankPaidFragment())
                fragmentTransaction.addToBackStack(null)
                extendedFabNext.text = "Save"
                extendedFabNext.icon = null
                currentFragment++
            }
        }

        fragmentTransaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {

        if (currentFragment > 0) {
            currentFragment--
           // if (currentFragment == 0) {
                extendedFabNext.text = "Next"
          //  }
        }

        when (currentFragment) {
            0 -> {
                supportActionBar?.subtitle = "Pd Info"
            }

            1 -> {
                supportActionBar?.subtitle = "Credit Info"
            }

            2 -> {
                supportActionBar?.subtitle = "Other Credit Info"
            }
        }
        super.onBackPressed()
    }
}