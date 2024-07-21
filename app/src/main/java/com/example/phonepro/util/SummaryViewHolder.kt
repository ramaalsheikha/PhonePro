package com.example.phonepro.util

import androidx.recyclerview.widget.RecyclerView
import com.example.phonepro.databinding.SummaruItemDesignBinding
import com.example.phonepro.domain.SummaryItemObject

class SummaryViewHolder(private val binding: SummaruItemDesignBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(summaryItemObject: SummaryItemObject) {
        binding.tvTitle.text = summaryItemObject.title
        binding.tvContent.text = summaryItemObject.content
    }
}