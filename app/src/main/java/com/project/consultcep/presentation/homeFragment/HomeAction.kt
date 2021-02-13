package com.project.consultcep.presentation.homeFragment

sealed class HomeAction {
    object Success : HomeAction()
    object Fail : HomeAction()
    object ToHistory : HomeAction()
}