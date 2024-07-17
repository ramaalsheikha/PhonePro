package com.example.phonepro.newutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonepro.databinding.ModelBinding
import com.example.phonepro.domain.ObjectModel

class ModelsAdapter(val list: List<ObjectModel>):RecyclerView.Adapter<ModelsViewHolder>() {
    /**
     *  iPhoneList = listOf(
     *             ObjectModel(iphonefourteenred,"iPhone 14","$600","  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."),
     *             ObjectModel(iphoneforteen,"iPhone 14 Max ","$70","  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."),
     *             ObjectModel(iphonefourteenyellow,"iPhone 14 Pro","$760","  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience.") )
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val modelBinding = ModelBinding.inflate(inflater,parent,false)
        return ModelsViewHolder(modelBinding)
    }

    override fun getItemCount(): Int {
        return list.size
        //    return 3
    }

    override fun onBindViewHolder(holder: ModelsViewHolder, position: Int) {
        holder.bind(list[position])
    // holder.bind(list[0])
    // holde.bind(ObjectModel(iphonefourteenred,"iPhone 14","$600","  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience.")

    }
}