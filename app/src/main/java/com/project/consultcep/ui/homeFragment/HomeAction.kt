package com.project.consultcep.ui.homeFragment

sealed class HomeAction {
    data class Success(val cep: String) : HomeAction()
    object Fail : HomeAction()
}