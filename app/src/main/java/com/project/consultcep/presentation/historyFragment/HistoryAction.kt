@file:Suppress("unused")

package com.project.consultcep.presentation.historyFragment

sealed class HistoryAction {

    object Success : HistoryAction()
    object ToBack : HistoryAction()
}