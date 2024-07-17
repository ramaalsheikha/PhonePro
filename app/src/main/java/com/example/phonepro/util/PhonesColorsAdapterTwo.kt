package com.example.phonepro.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.phonepro.R
import com.example.phonepro.databinding.SpinnerItemBinding
import com.example.phonepro.domain.SpinnerObject

class PhonesColorsAdapterTwo(context: Context, colorList: MutableList<SpinnerObject>) :
    ArrayAdapter<SpinnerObject>(context,0, colorList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,parent)
    }

    fun initView(position: Int,parent: ViewGroup):View{
        val colorObject = getItem(position)
        val inflater = LayoutInflater.from(parent.context)
        val binding = SpinnerItemBinding.inflate(inflater,parent,false)
        bind(binding,colorObject)
        return binding.root
    }
    fun bind(binding: SpinnerItemBinding,spinnerObject: SpinnerObject?){
       spinnerObject?.let {
           binding.tvColorName.text = spinnerObject.colorText
           binding.ivPhone.setImageResource(spinnerObject.image)
       }
    }
}