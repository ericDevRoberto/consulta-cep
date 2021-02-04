package com.project.consultcep.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepApiDao {
    @GET("{cep_user}.json/")
    fun getCep(@Path("cep_user") cep: String): Call<CepProperty>
}