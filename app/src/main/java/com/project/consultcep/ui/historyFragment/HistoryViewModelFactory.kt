package com.project.consultcep.ui.historyFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.consultcep.db.Dao.CepHistoryDao

@Suppress("UNCHECKED_CAST")
class HistoryViewModelFactory(private val dataSource: CepHistoryDao)
    :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HistoryViewModel::class.java)){
            return HistoryViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}