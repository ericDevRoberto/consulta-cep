package com.project.consultcep.presentation.historyFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.project.consultcep.databinding.ListItemHistoryTableBinding
import com.project.consultcep.domain.model.CepHistoryTable

class HistoryAdapter(private val clickListener: HistoryRecycleViewClickListener) : ListAdapter<CepHistoryTable, HistoryViewHolder>(HistoryDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ListItemHistoryTableBinding.inflate(layoutInflater, parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

        holder.bind(getItem(position), clickListener)
    }

}

class HistoryDiffCallBack : DiffUtil.ItemCallback<CepHistoryTable>() {
    override fun areItemsTheSame(oldItem: CepHistoryTable, newItem: CepHistoryTable): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CepHistoryTable, newItem: CepHistoryTable): Boolean {
        return oldItem.cepHistoryId == newItem.cepHistoryId
    }

}
