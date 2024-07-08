package com.example.phonepro.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonepro.databinding.ModelBinding
import com.example.phonepro.domain.ObjectModel

class ModelsAdapter(val modelsList:List<ObjectModel>,val modelClickListener: ModelClickListener) :RecyclerView.Adapter<ModelsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ModelBinding.inflate(inflater, parent, false)
        return ModelsViewHolder(binding, modelClickListener )
    }

    override fun getItemCount(): Int {
      return modelsList.size
    }

    override fun onBindViewHolder(holder: ModelsViewHolder, position: Int) {
        holder.bind(modelsList[position])
    }
}