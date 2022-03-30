package com.example.di
import com.example.data.repository.UserRepository
import com.example.domain.usecases.LoginAsCoach
import com.example.domain.usecases.LoginAsConsumer
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideLoginAsCoachUseCase (userRepository : UserRepository): LoginAsCoach {
        return  LoginAsCoach(repository = userRepository)
    }
    @Provides
    fun provideLoginAsConsumerUseCasee (userRepository : UserRepository): LoginAsConsumer {
        return  LoginAsConsumer(repository = userRepository)
    }


}