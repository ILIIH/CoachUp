package com.example.presentation.MainActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.LoginAsCoach
import com.example.domain.usecases.LoginAsConsumer
import com.example.domain.usecases.RegisterAsCoachUsecase
import com.example.domain.usecases.RegisterAsConsumerUsecase
import javax.inject.Inject

class MainActivityViewModelFactory @Inject constructor(
    private val LoginAsCoachUseCase : LoginAsCoach,
    private val LoginAsConsumerUseCase : LoginAsConsumer,
    private val RegisterAsCoachUsecase : RegisterAsCoachUsecase,
    private val RegisterAsConsumerUsecase: RegisterAsConsumerUsecase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(LoginAsCoachUseCase,LoginAsConsumerUseCase) as T
    }
}