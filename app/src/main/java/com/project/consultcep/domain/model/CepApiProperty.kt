package com.project.consultcep.domain.model

data class CepApiProperty(
    val status: Int,
    val code: String = String(),
    val state: String = String(),
    val city: String = String(),
    val district: String = String(),
    val address: String = String()
)

