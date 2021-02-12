package com.project.consultcep.presentation.homeFragment

import androidx.lifecycle.viewModelScope
import com.project.consultcep.data.db.Dao.CepChoiseDao
import com.project.consultcep.domain.model.CepChoiseTable
import com.project.consultcep.utils.ViewModelCore
import kotlinx.coroutines.launch

class HomeViewModel(
    dataBase: CepChoiseDao
) : ViewModelCore<HomeAction>() {

    private var cep = String()

    private val data = dataBase

    fun putCep(text: String) {
        cep = text
    }

    fun getCepOnClick() {
        if (cep.length == 9)
            getCepApi(cep = cep)
        else
            mutableLiveData.value = HomeAction.Fail
    }

    private fun getCepApi(cep: String) {
        viewModelScope.launch {
            val db = CepChoiseTable()
            db.cepChoose = cep
            data.insert(db)
        }
        mutableLiveData.value = HomeAction.Success(cep)
    }

    fun toHistory(){
        mutableLiveData.value = HomeAction.ToHistory
    }
}