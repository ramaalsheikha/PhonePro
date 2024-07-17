package com.example.phonepro.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.phonepro.R
import com.example.phonepro.databinding.ActivityPaymentBinding
import com.example.phonepro.domain.SelectedModelList

class PaymentActivity : AppCompatActivity() {
    lateinit var binding:ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        setupUI()
    }

    private fun getData() {
        val selectedModelList = intent.getParcelableExtra<SelectedModelList>(getString(R.string.selectedmodellist))
        Log.i("selectedModelList",selectedModelList!!.modelList.toString())
    }

    private fun setupUI() {
        showSpinnerAndPickupTime()
        setSpinnerAdapter()
        showCard()
    }

    private fun showSpinnerAndPickupTime() {
        binding.btnPlaceOrderOne.setOnClickListener {
            if (isValidateNameAndNumber()) {
                binding.clSpinner.visibility = View.VISIBLE
                binding.btnPlaceOrderOne.visibility = View.GONE

            }
        }
    }

    private fun isValidateNameAndNumber(): Boolean {
        val isVal: Boolean
        if (binding.etFullName.length() == 0) {
            binding.etFullName.error = getString(R.string.error_valid_name)
        } else {
            binding.etFullName.error = null
        }
        if (binding.etPhoneNumber.length() != 10) {
            binding.etPhoneNumber.error = getString(R.string.error_valid_number)
            isVal = false
        } else {
            binding.etPhoneNumber.error = null
            isVal = true
        }
        return isVal
    }

    private fun  setSpinnerAdapter(){
        val list  = listOf("_","Visa","Mastercard")
        binding.spCardType.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,list)
    }
    private fun showCard() {
        binding.spCardType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position)
                cardVisibility(selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                cardVisibility(null)
            }
        }
    }

    private fun cardVisibility(selectedItem: String?) {
        binding.btnPlaceOrder.visibility = if (selectedItem == "_") View.GONE else View.VISIBLE
        binding.clCard.visibility = if (selectedItem == "_") View.GONE else View.VISIBLE
    }



}