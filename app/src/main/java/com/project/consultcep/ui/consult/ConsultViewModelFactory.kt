package com.project.consultcep.ui.consult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException


class ConsultViewModelFactory(private val cep: String)
    :ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ConsultViewModel::class.java)){
            return ConsultViewModel(cep) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}