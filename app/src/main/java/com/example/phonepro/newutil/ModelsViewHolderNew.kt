package com.example.phonepro.newutil

import androidx.recyclerview.widget.RecyclerView
import com.example.phonepro.databinding.ModelBinding
import com.example.phonepro.domain.ObjectModel
import com.example.phonepro.util.ModelClickListener

class ModelsViewHolderNew(val modelBinding: ModelBinding,val modelClickListener: ModelClickListener):RecyclerView.ViewHolder(modelBinding.root) {
    fun bind(objectModel: ObjectModel){
        modelBinding.ivPhone.setImageResource(objectModel.image)
        modelBinding.tvName.text = objectModel.modelName
        modelBinding.tvPrice.text = objectModel.price
        modelBinding.btnExpand.setOnClickListener {
            modelClickListener.click(objectModel)
        }
    }
}