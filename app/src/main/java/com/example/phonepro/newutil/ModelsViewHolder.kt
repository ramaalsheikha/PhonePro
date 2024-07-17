package com.example.phonepro.newutil

import androidx.recyclerview.widget.RecyclerView
import com.example.phonepro.databinding.ModelBinding
import com.example.phonepro.domain.ObjectModel

class ModelsViewHolder(val modelBinding: ModelBinding):RecyclerView.ViewHolder(modelBinding.root) {
    fun bind(objectModel: ObjectModel){
        // ObjectModel(iphonefourteenred,"iPhone 14","$600","  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience.")
        modelBinding.ivPhone.setImageResource(objectModel.image)
        modelBinding.tvName.text = objectModel.modelName
    }
}