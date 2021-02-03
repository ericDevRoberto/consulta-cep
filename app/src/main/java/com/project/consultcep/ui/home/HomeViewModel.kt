package com.project.consultcep.ui.home

import com.project.consultcep.utils.ViewModelCore

class HomeViewModel :ViewModelCore<HomeAction>() {

    private var cep = String()

    fun putCep(text: String){
        cep = text
    }

    fun getCepOnClick() {
        if (cep.length == 9)
            mutableLiveData.value = HomeAction.Success(cep = cep)

        else
            mutableLiveData.value = HomeAction.Fail
    }

}