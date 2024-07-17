package com.example.phonepro.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.phonepro.domain.ObjectModel

class OnItemSelectedListenerObject(
    private val context: Context,
    private val selectedModel: ObjectModel,
    val onColorSelected: (String)->Unit,
) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
       val selectedColor = selectedModel.color[position].colorText
        Log.i("SelectedColor", "Color selected: $selectedColor")
        onColorSelected(selectedColor)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(
            context,
            "Please select phone color",
            Toast.LENGTH_LONG
        ).show()
    }
}
