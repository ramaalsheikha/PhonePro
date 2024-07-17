package com.example.phonepro.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.phonepro.R
import com.example.phonepro.databinding.SpinnerItemBinding
import com.example.phonepro.domain.SpinnerObject

class PhonesColorAdapter(context: Context, colorsList: ArrayList<SpinnerObject>) :
    ArrayAdapter<SpinnerObject>(context, 0, colorsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, parent)
    }

    private fun initView(position: Int, parent: ViewGroup): View {
        val colorItem = getItem(position)
        val inflater = LayoutInflater.from(parent.context)
        val binding = SpinnerItemBinding.inflate(inflater, parent, false)
        bind(binding, colorItem)
        return binding.root
    }

    private fun bind(spinnerItemBinding: SpinnerItemBinding, spinnerObject: SpinnerObject?) {
        spinnerObject?.let {
            spinnerItemBinding.ivPhone.setImageResource(spinnerObject.image)
            spinnerItemBinding.tvColorName.text = spinnerObject.colorText
        }
    }
}