package com.project.consultcep.data.api

import com.project.consultcep.domain.model.CepApiProperty
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepApiRepository {
    @GET("{cep_user}.json/")
    fun getCep(@Path("cep_user") cep: String): Call<CepApiProperty>
}