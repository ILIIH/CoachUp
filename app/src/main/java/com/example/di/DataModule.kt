package com.example.di
import android.content.Context
import com.example.data.api.ApiService
import com.example.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {
   @Provides

    fun getUserRepository(context: Context, retrofitServise: ApiService) :UserRepository  {
       return  UserRepository(context,retrofitServise)
    }

    @Provides

    fun getRetroServiseInstance(retrofit : Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun getRetrofitInstance(): Retrofit {
        return  Retrofit.Builder().baseUrl("https://scriptsdb.herokuapp.com").
        addConverterFactory(GsonConverterFactory.create()).build()
    }


}