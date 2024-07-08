package com.example.phonepro.util

import androidx.recyclerview.widget.RecyclerView
import com.example.phonepro.databinding.ModelBinding
import com.example.phonepro.domain.ObjectModel

class ModelsViewHolder(private val modelBinding: ModelBinding,private val modelClickListener: ModelClickListener) :
    RecyclerView.ViewHolder(modelBinding.root) {

    fun bind(objectModel: ObjectModel){
     modelBinding.ivPhone.setImageResource(objectModel.image)
     modelBinding.tvName.text = objectModel.modelName
     modelBinding.tvPrice.text =objectModel.price
     modelBinding.btnExpand.setOnClickListener {
         modelClickListener.click(objectModel)
     }
    }
}