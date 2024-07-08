package com.example.phonepro.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.Toast
import com.example.phonepro.R
import com.example.phonepro.domain.ObjectModel
import com.example.phonepro.databinding.ActivityModelDetailsBinding
import com.example.phonepro.domain.SelectedModelList
import com.example.phonepro.domain.SpinnerObject
import com.example.phonepro.util.Constants
import com.example.phonepro.util.PhonesColorAdapter

class ModelDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityModelDetailsBinding
    lateinit var selectedModel: ObjectModel
    var selectedColor: String = ""
    lateinit var colorList: List<SpinnerObject>
    var selectedStorage: String = ""
    val modelList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSelectedModel()
        initSpinnerList()
        buyAddClickListener()
    }

    private fun putModel(selectedModel: ObjectModel) {
        binding.imageView.setImageResource(selectedModel.image)
        binding.tvModelName.text = selectedModel.modelName
        binding.tvPrice.text = selectedModel.price
        binding.tvModelDescription.text = selectedModel.description
    }

    private fun getSelectedModel() {
        selectedModel = intent.getParcelableExtra<ObjectModel>(Constants.model)!!
        selectedModel?.let {
            putModel(selectedModel)
        }
    }

    private fun initSpinnerList() {
        colorList = listOf(
            SpinnerObject(R.drawable.iphonefourteenyellow, "Yellow"),
            SpinnerObject(R.drawable.iphonefourteenred, "Red"),
            SpinnerObject(R.drawable.iphoneforteen, "Purple"),
            SpinnerObject(R.drawable.background, "Black")
        )
        initSpinnerAdapter()
    }

    private fun initSpinnerAdapter() {
        val myAdapter = PhonesColorAdapter(this, colorList)
        binding.spColors.adapter = myAdapter
    }

    private fun getSelectedColor() {
        binding.spColors.apply {
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedColor = colorList[position].colorText
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(
                        this@ModelDetailsActivity,
                        "Please select phone color",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun getSelectedStorage() {
        binding.rgStorages.setOnCheckedChangeListener { group, checkedId ->
            selectedStorage = group.findViewById<RadioButton>(checkedId).text.toString()
        }
    }

    private fun buyAddClickListener() {
        binding.btnBuy.setOnClickListener {
            getSelectedColor()
            getSelectedStorage()
            initModelList()
            val intent = Intent(this, PaymentActivity::class.java)
            val selectedModelList = SelectedModelList(modelList)
            intent.putExtra(getString(R.string.selectedmodellist), selectedModelList)
            startActivity(intent)
        }
    }

    private fun initModelList() {
        modelList.apply {
            add(selectedModel.modelName)
            add(selectedModel.price)
            add(selectedColor)
            add(selectedStorage)
        }
    }
}
