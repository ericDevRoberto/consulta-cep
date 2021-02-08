package com.project.consultcep.ui.consultFragment

import com.project.consultcep.data.CepApiRepository
import com.project.consultcep.api.CepApiService
import com.project.consultcep.domain.model.CepApiProperty
import com.project.consultcep.utils.ViewModelCore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConsultViewModel(val cep: String) : ViewModelCore<ConsultAction>() {

    init {
        getCepApi()
    }

    private fun getCepApi() {
        val endPoint = CepApiService.builder().create(CepApiRepository::class.java)

        mutableLiveData.value = ConsultAction.Loading

        endPoint.getCep(cep).enqueue(object : Callback<CepApiProperty> {

            override fun onResponse(call: Call<CepApiProperty>, response: Response<CepApiProperty>) {

                mutableLiveData.value = when (response.body()?.status) {
                    200 -> response.body()?.let { ConsultAction.ApiSuccess(it) }
                    500 -> ConsultAction.ApiServerError
                    400 -> ConsultAction.ApiBadRequest
                    404 -> ConsultAction.ApiNotFound
                    else -> ConsultAction.ApiFail
                }
            }

            override fun onFailure(call: Call<CepApiProperty>, t: Throwable) {
                mutableLiveData.value = ConsultAction.ApiInternetError
            }
        })
    }

    fun backToHome() {

        mutableLiveData.value = ConsultAction.BackToHome
    }

    fun toHistory(){
        mutableLiveData.value = ConsultAction.ToHistory
    }
}