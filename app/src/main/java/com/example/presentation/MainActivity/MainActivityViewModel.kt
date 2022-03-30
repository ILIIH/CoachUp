package com.example.presentation.MainActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.api.ApiService
import com.example.domain.models.Coach_Model
import com.example.domain.models.Consumer_Model
import com.example.domain.usecases.LoginAsCoach
import com.example.domain.usecases.LoginAsConsumer
import kotlinx.coroutines.*
import retrofit2.Response

class MainActivityViewModel(
    private val LoginAsCoachUseCase : LoginAsCoach,
    private val LoginAsConsumerUseCase : LoginAsConsumer
) : ViewModel() {


    var userConsumer : MutableLiveData<Response<ArrayList<Consumer_Model>>> = MutableLiveData()
    var userCoach : MutableLiveData<Response<ArrayList<Coach_Model>>> = MutableLiveData()
    var INCORRECT_DATA : MutableLiveData<Boolean> = MutableLiveData()






     fun check_user(Login:String, Password:String  ){

         val handler = CoroutineExceptionHandler { _, exception ->
             println("CoroutineExceptionHandler got $exception")
         }

         val job : Job =  GlobalScope.launch(handler) {
             userCoach.postValue( LoginAsCoachUseCase.execute(Login, Password))
             userConsumer.postValue( LoginAsConsumerUseCase.execute(Login, Password))
         }
         job.start()

       // INCORRECT_DATA.value = true

    }

    override fun onCleared() {
        super.onCleared()
    }
}