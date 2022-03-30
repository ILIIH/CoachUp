package com.example.domain.repository

import com.example.domain.models.Coach_Model
import com.example.domain.models.Consumer_Model
import retrofit2.Response

interface RepositoryInterface {

    suspend fun saveCoachUser(coach :Coach_Model ) : String

    suspend fun saveConsumerUser(consumer : Consumer_Model) : String

    suspend fun loadCoachUser(login : String, password: String): Response<ArrayList<Coach_Model>>

    suspend fun loadConsumerUser(login : String, password: String): Response<ArrayList<Consumer_Model>>

}