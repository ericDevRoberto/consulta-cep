package com.project.consultcep.presentation.consultFragment

import com.project.consultcep.domain.model.CepApiProperty

sealed class ConsultAction {
    data class ApiSuccess(val result: CepApiProperty) : ConsultAction()
    object ApiFail: ConsultAction()
    object Loading : ConsultAction()
    object ApiNotFound : ConsultAction()
    object ApiInternetError : ConsultAction()
    object ApiServerError : ConsultAction()
    object ApiBadRequest : ConsultAction()
    object BackToHome : ConsultAction()
    object ToHistory : ConsultAction()
}