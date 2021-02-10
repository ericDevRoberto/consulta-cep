package com.project.consultcep.ui.historyFragment

sealed class HistoryAction {
    object Success : HistoryAction()
    object toClean : HistoryAction()
    object toBack : HistoryAction()
}