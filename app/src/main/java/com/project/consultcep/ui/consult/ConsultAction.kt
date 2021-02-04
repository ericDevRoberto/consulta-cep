package com.project.consultcep.ui.consult

import com.project.consultcep.network.CepProperty

sealed class ConsultAction {
    data class Success(val result: CepProperty) : ConsultAction()
    data class Fail(val messageFail: String) : ConsultAction()
    object Loading : ConsultAction()
}