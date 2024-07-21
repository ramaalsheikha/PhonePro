package com.example.phonepro.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.phonepro.R
import com.example.phonepro.databinding.ActivitySummaryBinding
import com.example.phonepro.domain.CustomerList
import com.example.phonepro.domain.SelectedModelList
import com.example.phonepro.domain.SummaryItemObject
import com.example.phonepro.util.SummaryAdapter

class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding
    private lateinit var customerInfo: CustomerList
    private lateinit var modelInfo: SelectedModelList
    private val summaryList: MutableList<SummaryItemObject> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        initSummaryList()
        initSummaryAdapter()
    }

    private fun initSummaryAdapter() {
        binding.rvSummary.adapter = SummaryAdapter(summaryList)
    }

    private fun initSummaryList() {
        val customerTitleList = listOf("Name :", "Number :", "Address :")
        val modelTitleList = listOf("Model Name :", "Model Price :", "Model Color :", "Model Storage :")
        for (i in customerInfo.paymentList.indices) {
            summaryList.add(SummaryItemObject(customerTitleList[i], customerInfo.paymentList[i]))
        }
        for (i in modelInfo.modelList.indices) {
            summaryList.add(SummaryItemObject(modelTitleList[i], modelInfo.modelList[i]))
        }
    }

    private fun getData() {
        customerInfo = intent.getParcelableExtra(getString(R.string.customerinfo))!!
        modelInfo = intent.getParcelableExtra(getString(R.string.selectedmodellist))!!
        Log.i("SummaryActivity", "Customer Info: $customerInfo")
        Log.i("SummaryActivity", "Model Info: $modelInfo")
    }
}
