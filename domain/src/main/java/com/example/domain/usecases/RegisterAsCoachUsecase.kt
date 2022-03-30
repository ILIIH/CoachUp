package com.example.domain.usecases

import com.example.domain.models.Coach_Model
import com.example.domain.repository.RepositoryInterface

class RegisterAsCoachUsecase(private val repository : RepositoryInterface)  {

   suspend fun execute(coach : Coach_Model) = repository.saveCoachUser(coach)

}