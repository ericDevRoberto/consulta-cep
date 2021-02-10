package com.project.consultcep.ui.consultFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.consultcep.db.Dao.CepHistoryDao
import java.lang.IllegalArgumentException


class ConsultViewModelFactory(
    private val cep: String,
    private val dataSource: CepHistoryDao
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ConsultViewModel::class.java)) {
            return ConsultViewModel(cep, dataSource) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}