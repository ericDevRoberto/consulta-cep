package com.project.consultcep.presentation.historyFragment.adapter

import androidx.recyclerview.widget.RecyclerView
import com.project.consultcep.databinding.ListItemHistoryTableBinding
import com.project.consultcep.domain.model.CepHistoryTable

class HistoryViewHolder(val binding: ListItemHistoryTableBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CepHistoryTable, clickListener: HistoryRecycleViewClickListener) {
        binding.cep = item
        binding.executePendingBindings()
        binding.clickListener = clickListener
    }
}

class HistoryRecycleViewClickListener(val clickListener: (cepHistoryId: String) -> Unit){

    fun onclick(history: CepHistoryTable) = clickListener(history.cepCode)
}