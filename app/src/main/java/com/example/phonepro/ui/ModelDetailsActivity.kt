package com.example.phonepro.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import com.example.phonepro.R
import com.example.phonepro.databinding.ActivityModelDetailsBinding
import com.example.phonepro.domain.ObjectModel
import com.example.phonepro.domain.SelectedModelList
import com.example.phonepro.domain.SpinnerObject
import com.example.phonepro.util.Constants
import com.example.phonepro.util.OnItemSelectedListenerObject
import com.example.phonepro.util.PhonesColorAdapter
import com.example.phonepro.util.PhonesColorsAdapterTwo

class ModelDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityModelDetailsBinding
    lateinit var selectedModel: ObjectModel
    lateinit var selectedColor:String
    private var selectedStorage: String = null.toString()
    private val modelList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSelectedModel()
        buyAddClickListener()
    }

    private fun getSelectedModel() {
        selectedModel = intent.getParcelableExtra(Constants.model)!!
        putModel(selectedModel)
    }

    private fun putModel(selectedModel: ObjectModel) {
        binding.imageView.setImageResource(selectedModel.image)
        binding.tvModelName.text = selectedModel.modelName
        binding.tvPrice.text = selectedModel.price
        binding.tvModelDescription.text = selectedModel.description
        initSpinnerAdapter(selectedModel)
    }

    private fun initSpinnerAdapter(selectedModel: ObjectModel) {
        val myAdapter = PhonesColorsAdapterTwo(this, selectedModel.color)
        binding.spColors.adapter = myAdapter
      //  getSelectedColor()
    }

 /*   private fun getSelectedColor() {
        binding.spColors.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               // selectedColor = selectedModel.color[position].colorText

               /* val selectedItem = parent?.getItemAtPosition(position) as SpinnerObject
                selectedColor = selectedItem.colorText*/




              Log.i("SelectedColor", "Color selected: $selectedColor")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedColor = null.toString()
                Toast.makeText(
                    this@ModelDetailsActivity,
                    "Please select phone color",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }*/

    private fun getSelectedStorage() {
        val storageList = listOf<RadioButton>(binding.rb500GB, binding.rb800GB, binding.rb1TB)
        storageList.forEach { storage ->
            if (storage.isChecked) {
                selectedStorage = storage.text.toString()
            }
        }
    }

    private fun buyAddClickListener() {
        binding.btnBuy.setOnClickListener {
            getSelectedStorage()
            if (colorAndStorageValidation()) {
                initModelList()
                Log.i("ModelList", modelList.toString())
                val intent = Intent(this, PaymentActivity::class.java)
                val selectedModelList = SelectedModelList(modelList)
                intent.putExtra(getString(R.string.selectedmodellist), selectedModelList)
                startActivity(intent)
            }
        }
    }

    private fun colorAndStorageValidation(): Boolean {
        val selectedItem = binding.spColors.selectedItem as SpinnerObject
        selectedColor = selectedItem.colorText
        var isVal = true
        if (selectedStorage == "null") {
            Toast.makeText(this, "Please select storage", Toast.LENGTH_LONG).show()
            isVal = false
        }
        if (selectedColor == "_") {
            Toast.makeText(this, "Please select color", Toast.LENGTH_LONG).show()
            isVal = false
        }
        return isVal
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
