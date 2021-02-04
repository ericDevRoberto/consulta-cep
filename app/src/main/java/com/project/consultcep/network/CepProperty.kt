package com.project.consultcep.network

data class CepProperty(
    val status: Int,
    val code: String = String(),
    val state: String = String(),
    val city: String = String(),
    val district: String = String(),
    val address: String = String()
)

