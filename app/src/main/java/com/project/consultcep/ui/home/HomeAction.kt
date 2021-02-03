package com.project.consultcep.ui.home

sealed class HomeAction {
    data class Success(val cep: String) : HomeAction()
    object Fail : HomeAction()
}