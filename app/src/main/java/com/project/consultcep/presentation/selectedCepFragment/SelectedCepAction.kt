package com.project.consultcep.presentation.selectedCepFragment

import com.project.consultcep.domain.model.CepHistoryTable

sealed class SelectedCepAction {

    data class Success(val cepTable: CepHistoryTable) : SelectedCepAction()
    object ToBack : SelectedCepAction()
}