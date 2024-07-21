package com.example.phonepro.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.phonepro.R
import com.example.phonepro.databinding.ActivityPaymentBinding
import com.example.phonepro.domain.CustomerList
import com.example.phonepro.domain.SelectedModelList

class PaymentActivity : AppCompatActivity() {
    lateinit var binding: ActivityPaymentBinding
   lateinit var selectedModelList:SelectedModelList
    var customerInfo: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        setupUI()
        setUpListener()

    }

    private fun getData() {
         selectedModelList =
             intent.getParcelableExtra<SelectedModelList>(getString(R.string.selectedmodellist))!!
        Log.i("selectedModelList", selectedModelList!!.modelList.toString())
    }

    private fun setupUI() {
        setSpinnerAdapter()
        showCardTypes()
        showCard()
    }

    private fun showCardTypes() {
        binding.btnPlaceOrderOne.setOnClickListener {
            if (isValidateNameAndNumber()) {
                binding.clSpinner.visibility = View.VISIBLE
                binding.btnPlaceOrderOne.visibility = View.GONE

            }
        }
    }

    private fun isValidateNameAndNumber(): Boolean {
        var validated: Boolean = true
        if (binding.etFullName.length() == 0) {
            binding.etFullName.error = getString(R.string.error_valid_name)
            validated = false
        }
        if (binding.etPhoneNumber.length() != 10) {
            binding.etPhoneNumber.error = getString(R.string.error_valid_number)
            validated = false
        }
        if (binding.etDeliveryAddress.text.isEmpty()) {
            binding.etDeliveryAddress.error = "Please enter your address"
            validated = false
        }
        return validated
    }

    private fun setSpinnerAdapter() {
        val list = listOf("_", "Visa", "Mastercard")
        binding.spCardType.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
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
        binding.btnPlaceOrderTwo.visibility = if (selectedItem == "_") View.GONE else View.VISIBLE
        binding.clCard.visibility = if (selectedItem == "_") View.GONE else View.VISIBLE
    }

    private fun setUpListener() {
        binding.btnPlaceOrderTwo.setOnClickListener {
            if (cardInfoValidation()) {
                initCustomerInfo()
                Log.i("customerInfo",customerInfo.toString())
                val intent = Intent(this , SummaryActivity::class.java)
                val customerInfoObject = CustomerList(customerInfo)
                intent.putExtra(getString(R.string.customerinfo),customerInfoObject)
                intent.putExtra(getString(R.string.selectedmodellist),selectedModelList)
                startActivity(intent)
            }

        }
    }

    private fun cardInfoValidation(): Boolean {
        var validated = true
        if (binding.etCardNumber.length() != 16) {
            binding.etCardNumber.error = getString(R.string.error_valid_card_number)
            validated = false
        }
        if (binding.etCardDate.text.isEmpty()) {
            binding.etCardDate.error = getString(R.string.error_valid_card_date)
            validated = false
        }
        if (binding.etCardCvv.length() != 3) {
            binding.etCardCvv.error = getString(R.string.error_valid_card_cvv)
            validated = false
        }
        return validated
    }

    private fun initCustomerInfo() {
        customerInfo.apply {
            add(binding.etFullName.text.toString())
            add(binding.etPhoneNumber.text.toString())
            add(binding.etDeliveryAddress.text.toString())
        }
    }




}