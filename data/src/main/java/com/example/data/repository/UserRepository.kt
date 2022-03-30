package com.example.data.repository

import android.content.Context
import com.example.data.api.ApiService
import com.example.domain.models.Coach_Model
import com.example.domain.models.Consumer_Model
import com.example.domain.repository.RepositoryInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class UserRepository @Inject constructor(val context: Context, var retrofitServise: ApiService): RepositoryInterface {



    override fun saveCoachUser(coach :Coach_Model ) : String{
        TODO()
    }

    override fun saveConsumerUser(consumer : Consumer_Model) : String {
        TODO()
    }

    override suspend fun loadCoachUser(login: String, password: String): Response<ArrayList<Coach_Model>> = retrofitServise.check_coach(login,password)

    override suspend fun loadConsumerUser(login : String,password: String):Response<ArrayList<Consumer_Model>>   = retrofitServise.check_customers(login,password)
}