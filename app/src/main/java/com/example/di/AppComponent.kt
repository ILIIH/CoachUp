package com.example.di

import com.example.data.repository.UserRepository
import com.example.domain.repository.RepositoryInterface
import com.example.presentation.MainActivity.Login_Registration_Fragments.Login
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class,DataModule::class,DomainModule::class])
interface AppComponent {
    fun injectVmFactory(login: Login)
    fun injectRetrofit(repository: RepositoryInterface)
}