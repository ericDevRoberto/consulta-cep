package com.project.consultcep.presentation.historyFragment

import androidx.lifecycle.viewModelScope
import com.project.consultcep.data.db.Dao.CepChoiseDao
import com.project.consultcep.data.db.Dao.CepHistoryDao
import com.project.consultcep.domain.model.CepChoiseTable
import com.project.consultcep.utils.ViewModelCore
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val bdCep : CepChoiseDao,
    val dataBase: CepHistoryDao
    ): ViewModelCore<HistoryAction>() {

    val allHistoryCep = dataBase.getAllHistory()

    fun toBack(){
        mutableLiveData.value = HistoryAction.ToBack
    }

    fun toCleanData(){
        viewModelScope.launch {
            dataBase.clearData()
        }
    }

    fun getCepToSelected(cep : String){
        viewModelScope.launch {
            val db = CepChoiseTable()
            db.cepChoose = cep
            bdCep.insert(db)

            mutableLiveData.value = HistoryAction.Success
        }
    }


}