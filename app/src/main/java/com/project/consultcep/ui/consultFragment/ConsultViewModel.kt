package com.project.consultcep.ui.consultFragment

import androidx.lifecycle.viewModelScope
import com.project.consultcep.api.CepApiService
import com.project.consultcep.data.CepApiRepository
import com.project.consultcep.db.Dao.CepChoiseDao
import com.project.consultcep.db.Dao.CepHistoryDao
import com.project.consultcep.domain.model.CepApiProperty
import com.project.consultcep.domain.model.CepChoiseTable
import com.project.consultcep.domain.model.CepHistoryTable
import com.project.consultcep.utils.ViewModelCore
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConsultViewModel(
    val dataBase : CepHistoryDao,
    val dbCep : CepChoiseDao
    ) : ViewModelCore<ConsultAction>() {

    private val dataSource = dataBase

    override fun onCleared() {
        super.onCleared()

        viewModelScope.launch {
            dataSource.clearData()
        }
    }
   init{
       lastCep()
   }

    private fun lastCep() {

        viewModelScope.launch {
            val lastCep = dbCep.getLastCepRegistered()

            getCepApi(lastCep)
        }
    }

    private fun getCepApi(cep: CepChoiseTable) {
        val endPoint = CepApiService.builder().create(CepApiRepository::class.java)

        mutableLiveData.value = ConsultAction.Loading

        endPoint.getCep(cep.cepChoose).enqueue(object : Callback<CepApiProperty> {

            override fun onResponse(call: Call<CepApiProperty>, response: Response<CepApiProperty>) {

                mutableLiveData.value = when (response.body()?.status) {
                    200 -> response.body()?.let { success(it) }
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

    private fun success(cepApiProperty: CepApiProperty) : ConsultAction {

        viewModelScope.launch {

            val db = CepHistoryTable()
            db.cepAddress = cepApiProperty.address
            db.cepCity = cepApiProperty.city
            db.cepCode = cepApiProperty.code
            db.cepDistrict = cepApiProperty.district
            db.cepState = cepApiProperty.state
            dataSource.insert(db)

            mutableLiveData.value = ConsultAction.ApiSuccess(cepApiProperty)
        }

        return ConsultAction.Loading
    }

    fun backToHome() {

        mutableLiveData.value = ConsultAction.BackToHome
    }

    fun toHistory(){
        mutableLiveData.value = ConsultAction.ToHistory
    }
}