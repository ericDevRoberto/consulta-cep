package com.project.consultcep.ui.home

import com.project.consultcep.network.CepApiDao
import com.project.consultcep.network.CepApiService
import com.project.consultcep.network.CepProperty
import com.project.consultcep.utils.ViewModelCore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModelCore<HomeAction>() {

    private var cep = String()

    fun putCep(text: String) {
        cep = text
    }

    fun getCepOnClick() {
        if (cep.length == 9)
            getCepApi(cep = cep)
        else
            mutableLiveData.value = HomeAction.Fail
    }

    private fun getCepApi(cep: String) {

        mutableLiveData.value = HomeAction.Success(cep)

//        val endPoint = CepApiService.builder().create(CepApiDao::class.java)
//
//        endPoint.getCep(cep).enqueue(object : Callback<CepProperty> {
//
//            override fun onResponse(call: Call<CepProperty>, response: Response<CepProperty>) {
//
//                mutableLiveData.value = when (response.body()?.status) {
//                    200 -> response.body()?.let {HomeAction.Success(it.code)}
//                    500 -> HomeAction.Success("ERROR 500")
//                    400 -> HomeAction.Success("ERROR 400")
//                    else -> HomeAction.Success(response.body()?.status.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<CepProperty>, t: Throwable) {
//                mutableLiveData.value = HomeAction.Success("API DEU ERROR")
//            }
//
//        })
    }
}