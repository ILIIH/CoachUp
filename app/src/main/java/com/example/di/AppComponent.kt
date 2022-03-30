package com.example.di

import com.example.domain.repository.RepositoryInterface
import com.example.presentation.MainActivity.Login_Registration_Fragments.Login
import com.example.presentation.MainActivity.Login_Registration_Fragments.RegistartionAsCoach
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class,DataModule::class,DomainModule::class])
interface AppComponent {
    fun injevtVmFactoryRegistrCoach(registrationAsCoach: RegistartionAsCoach)
    fun injectVmFactory(login: Login)
    fun injectRetrofit(repository: RepositoryInterface)
}