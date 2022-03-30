package com.example.domain.usecases

import com.example.domain.models.Consumer_Model
import com.example.domain.repository.RepositoryInterface

class LoginAsConsumer (private val repository : RepositoryInterface) {

    suspend fun execute(login : String,password: String)  = repository.loadConsumerUser(login,password);
}