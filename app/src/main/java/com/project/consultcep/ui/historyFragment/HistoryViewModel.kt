package com.project.consultcep.ui.historyFragment

import androidx.lifecycle.viewModelScope
import com.project.consultcep.db.Dao.CepHistoryDao
import com.project.consultcep.utils.ViewModelCore
import kotlinx.coroutines.launch

class HistoryViewModel(val dataBase: CepHistoryDao): ViewModelCore<HistoryAction>() {

    val allHistoryCep = dataBase.getAllHistory()

    fun toBack(){
        mutableLiveData.value = HistoryAction.toBack
    }

    fun toCleanData(){
        viewModelScope.launch {
            dataBase.clearData()
        }
    }

}