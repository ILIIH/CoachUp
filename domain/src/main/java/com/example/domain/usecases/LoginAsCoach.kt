package com.example.domain.usecases

import com.example.domain.repository.RepositoryInterface

class LoginAsCoach(private val repository : RepositoryInterface) {

    suspend fun execute(login : String,password: String) = repository.loadCoachUser(login,password)
}