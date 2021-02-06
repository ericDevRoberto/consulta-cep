package com.project.consultcep.ui.consult

import com.project.consultcep.data.CepProperty

sealed class ConsultAction {
    data class ApiSuccess(val result: CepProperty) : ConsultAction()
    object ApiFail: ConsultAction()
    object Loading : ConsultAction()
    object ApiNotFound : ConsultAction()
    object ApiInternetError : ConsultAction()
    object ApiServerError : ConsultAction()
    object ApiBadRequest : ConsultAction()
    object BackToHome : ConsultAction()
}