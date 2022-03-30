package com.example.app

import android.app.Application
import com.example.di.AppComponent
import com.example.di.AppModule
import com.example.di.DaggerAppComponent

class App : Application()
{
    lateinit var  appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()

    }
}