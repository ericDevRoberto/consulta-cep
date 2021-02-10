package com.project.consultcep.ui.homeFragment

import com.project.consultcep.utils.ViewModelCore

class HomeViewModel : ViewModelCore<HomeAction>() {

    private var cep = String()

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

        mutableLiveData.value = HomeAction.Success(cep)
    }

    fun toHistory(){
        mutableLiveData.value = HomeAction.ToHistory
    }
}