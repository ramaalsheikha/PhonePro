package com.example.phonepro.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonepro.databinding.SummaruItemDesignBinding
import com.example.phonepro.domain.SummaryItemObject

class SummaryAdapter(private val list: List<SummaryItemObject>) : RecyclerView.Adapter<SummaryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SummaruItemDesignBinding.inflate(inflater, parent, false)
        return SummaryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        val summaryItemObject = list[position]
        holder.bind(summaryItemObject)
    }
}