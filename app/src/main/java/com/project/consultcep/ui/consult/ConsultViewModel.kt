package com.project.consultcep.ui.consult

import com.project.consultcep.network.CepApiDao
import com.project.consultcep.network.CepApiService
import com.project.consultcep.network.CepProperty
import com.project.consultcep.utils.ViewModelCore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConsultViewModel(val cep: String) : ViewModelCore<ConsultAction>() {

    init {
        getCepApi()
    }


    fun getCepApi() {
        val endPoint = CepApiService.builder().create(CepApiDao::class.java)

        mutableLiveData.value = ConsultAction.Loading

        endPoint.getCep(cep).enqueue(object : Callback<CepProperty> {

            override fun onResponse(call: Call<CepProperty>, response: Response<CepProperty>) {

                when (response.body()?.status) {
                    200 -> response.body()?.let { success(it) }
                    500 -> ConsultAction.Fail("ERROR 500")
                    400 -> ConsultAction.Fail("ERROR 400")
                    else -> ConsultAction.Fail(response.body()?.status.toString())
                }
            }

            override fun onFailure(call: Call<CepProperty>, t: Throwable) {
                mutableLiveData.value = ConsultAction.Fail(t.message.toString())
            }

        })
    }

    fun success(cepProperty: CepProperty) {
        mutableLiveData.value = ConsultAction.Success(cepProperty)
    }


}