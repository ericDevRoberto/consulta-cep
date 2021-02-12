package com.project.consultcep.presentation.homeFragment

sealed class HomeAction {
    data class Success(val cep: String) : HomeAction()
    object Fail : HomeAction()
    object ToHistory : HomeAction()
}