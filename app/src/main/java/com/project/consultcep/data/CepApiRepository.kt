package com.project.consultcep.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepApiRepository {
    @GET("{cep_user}.json/")
    fun getCep(@Path("cep_user") cep: String): Call<CepProperty>
}