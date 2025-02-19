package com.android1.petrol_pump.ui.bill_invoice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android1.petrol_pump.ui.bill_invoice.AdapterCallbackInterface
import com.android1.petrol_pump.R
import com.android1.petrol_pump.model.CreditInfoFormData
import com.android1.petrol_pump.ui.bill_invoice.adapter.CreditInfoAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreditInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreditInfoFragment : Fragment(), AdapterCallbackInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var buttonAddItem: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewCI = inflater.inflate(R.layout.fragment_credit_info, container, false)
        // Inflate the layout for this fragment
        val recyclerView: RecyclerView = viewCI.findViewById(R.id.recyclerViewPdInfo)
        buttonAddItem = viewCI.findViewById(R.id.button_add)

        val adapter = CreditInfoAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        val formData = CreditInfoFormData("","","","","","","")
        // Add the item to the adapter
        adapter.addItem(formData)

        buttonAddItem.setOnClickListener {
            // Create a new FormData object
            val formData = CreditInfoFormData("","","","","","","")
            // Add the item to the adapter
            adapter.addItem(formData)

            buttonAddItem.visibility = View.GONE
        }
        return viewCI
    }

    override fun onEventTriggered(isVisible: Boolean) {
        buttonAddItem.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreditInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreditInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}