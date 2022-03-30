package com.example.di

import android.content.Context
import com.example.domain.usecases.LoginAsCoach
import com.example.domain.usecases.LoginAsConsumer
import com.example.presentation.MainActivity.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideMainAcrivityViewModelFactory(
     LoginAsCoachUseCase : LoginAsCoach,
     LoginAsConsumerUseCase : LoginAsConsumer
    ) : MainActivityViewModelFactory =  MainActivityViewModelFactory(LoginAsCoachUseCase,  LoginAsConsumerUseCase)
    @Provides
    fun provideContext(): Context = context

}