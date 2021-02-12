package com.project.consultcep.presentation.historyFragment

sealed class HistoryAction {
    object Success : HistoryAction()
    object toClean : HistoryAction()
    object toBack : HistoryAction()
}