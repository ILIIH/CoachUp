package com.example.di

import android.content.Context
import com.example.domain.usecases.LoginAsCoach
import com.example.domain.usecases.LoginAsConsumer
import com.example.domain.usecases.RegisterAsCoachUsecase
import com.example.domain.usecases.RegisterAsConsumerUsecase
import com.example.presentation.MainActivity.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideMainAcrivityViewModelFactory(
     LoginAsCoachUseCase : LoginAsCoach,
     LoginAsConsumerUseCase : LoginAsConsumer,
     RegisterAsCoachUsecase : RegisterAsCoachUsecase,
     RegisterAsConsumerUsecase: RegisterAsConsumerUsecase
    ) : MainActivityViewModelFactory =  MainActivityViewModelFactory(LoginAsCoachUseCase,  LoginAsConsumerUseCase,RegisterAsCoachUsecase,RegisterAsConsumerUsecase)
    @Provides
    fun provideContext(): Context = context

}