package com.example.domain.models

import java.io.Serializable

data class Coach_Model(
    val About_myself: String,
    val Accreditation_level: String,
    val Experience: Int,
    val Login: String,
    val Name: String,
    val Password: String,
    val Patronymic: String,
    val Surname: String
) : Serializable