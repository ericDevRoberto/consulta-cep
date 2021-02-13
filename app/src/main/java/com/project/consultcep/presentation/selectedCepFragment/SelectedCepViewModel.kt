package com.project.consultcep.presentation.selectedCepFragment

import androidx.lifecycle.viewModelScope
import com.project.consultcep.data.db.Dao.CepChoiseDao
import com.project.consultcep.data.db.Dao.CepHistoryDao
import com.project.consultcep.utils.ViewModelCore
import kotlinx.coroutines.launch

class SelectedCepViewModel(
    private val bdChoice: CepChoiseDao,
    val dbHistory: CepHistoryDao

) : ViewModelCore<SelectedCepAction>() {

    init {

        getCep()
    }

    override fun onCleared() {
        super.onCleared()

        viewModelScope.launch {

            bdChoice.clearData()
        }
    }

    private fun getCep(){
        viewModelScope.launch {

            val cep : String = bdChoice.getLastCepRegistered().cepChoose

            val table = dbHistory.getSelectedHistory(cep)

            mutableLiveData.value = SelectedCepAction.Success(table)
        }
    }

    fun toBack(){
        mutableLiveData.value = SelectedCepAction.ToBack
    }
}