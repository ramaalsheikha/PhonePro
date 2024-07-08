package com.example.phonepro.newutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonepro.databinding.ModelBinding
import com.example.phonepro.domain.ObjectModel
import com.example.phonepro.util.ModelClickListener

class ModelsAdapterNew(val modelList: List<ObjectModel>,val modelClickListener: ModelClickListener):RecyclerView.Adapter<ModelsViewHolderNew> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelsViewHolderNew {
        val inflater = LayoutInflater.from(parent.context)
        val modelBinding = ModelBinding.inflate(inflater,parent,false)
        return  ModelsViewHolderNew(modelBinding,modelClickListener)
    }

    override fun getItemCount(): Int {
       return modelList.size
    }

    override fun onBindViewHolder(holder: ModelsViewHolderNew, position: Int) {
        holder.bind(modelList[position])
    }

}