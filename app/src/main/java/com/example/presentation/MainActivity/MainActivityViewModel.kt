package com.example.presentation.MainActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.api.ApiService
import com.example.domain.LoginStatuses
import com.example.domain.models.Coach_Model
import com.example.domain.models.Consumer_Model
import com.example.domain.usecases.LoginAsCoach
import com.example.domain.usecases.LoginAsConsumer
import com.example.domain.usecases.RegisterAsCoachUsecase
import com.example.domain.usecases.RegisterAsConsumerUsecase
import kotlinx.coroutines.*
import retrofit2.Response

class MainActivityViewModel(
    private val LoginAsCoachUseCase : LoginAsCoach,
    private val LoginAsConsumerUseCase : LoginAsConsumer,
    private val RegisterAsCoachUsecase : RegisterAsCoachUsecase,
    private val RegisterAsConsumerUsecase: RegisterAsConsumerUsecase
) : ViewModel() {


    var userConsumer : MutableLiveData<Response<ArrayList<Consumer_Model>>> = MutableLiveData()
    var userCoach : MutableLiveData<Response<ArrayList<Coach_Model>>> = MutableLiveData()
    var LoginStatus: MutableLiveData<LoginStatuses> = MutableLiveData()
    var StatusOfIncertingCoach : MutableLiveData<String> = MutableLiveData();


    fun incert_coach(        Patronymic:String,
                               Login:String,
                               Name:String,
                               Surname:String,
                               Password:String,
                               About_myself:String,
                               Experience:Int,
                               Accreditation_level:String)
    {


        val WorkCorutine = viewModelScope.launch {

            StatusOfIncertingCoach.postValue(RegisterAsCoachUsecase.execute(Coach_Model(About_myself,Accreditation_level,Experience,Login,Name,Password,Patronymic,Surname)))
        }


    }



     fun check_user(Login:String, Password:String  ) {

         val handler = CoroutineExceptionHandler { _, exception ->
             println("CoroutineExceptionHandler got $exception")
         }

         val job: Job = GlobalScope.launch(handler) {
             userCoach.postValue(LoginAsCoachUseCase.execute(Login, Password))
             userConsumer.postValue(LoginAsConsumerUseCase.execute(Login, Password))
         }
         job.start()
     }

    fun CheckReciavedCoach(userConsumer:Response<ArrayList<Coach_Model>>){
        when (userConsumer.code()) {
            in 500..599 -> LoginStatus.postValue(LoginStatuses.SERVER_ERROR)
            in 400..499 -> LoginStatus.postValue(LoginStatuses.SERVER_ERROR)
            in 200..299 -> {
                if(userConsumer.body()!!.isEmpty()){
                    if(LoginStatus.value?.equals(LoginStatuses.INCORRECT_CONSUMER_DATA)?:false )LoginStatus.postValue(LoginStatuses.NO_ACCOUNT)
                    else LoginStatus.postValue(LoginStatuses.INCORRECT_COACH_DATA)
                }
                else LoginStatus.postValue(LoginStatuses.SUCCSESS_COACH)
            }
        }
    }

    fun CheckReciavedConsumer(userConsumer:Response<ArrayList<Consumer_Model>>){
        when (userConsumer.code()) {
            in 500..599 -> LoginStatus.postValue(LoginStatuses.SERVER_ERROR)
            in 400..499 -> LoginStatus.postValue(LoginStatuses.SERVER_ERROR)
            in 200..299 -> {
                if(userConsumer.body()!!.isEmpty()){
                    if(LoginStatus.value?.equals(LoginStatuses.INCORRECT_COACH_DATA)?:false )LoginStatus.postValue(LoginStatuses.NO_ACCOUNT)
                    else LoginStatus.postValue(LoginStatuses.INCORRECT_CONSUMER_DATA)
                }
                else LoginStatus.postValue(LoginStatuses.SUCCSESS_CONSUMER)
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
    }
}