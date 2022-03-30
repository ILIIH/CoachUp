package com.example.domain.usecases

import com.example.domain.models.Consumer_Model
import com.example.domain.repository.RepositoryInterface

class RegisterAsConsumerUsecase(private val repository : RepositoryInterface)  {

    public fun execute(consumer : Consumer_Model) = repository.saveConsumerUser(consumer)
}