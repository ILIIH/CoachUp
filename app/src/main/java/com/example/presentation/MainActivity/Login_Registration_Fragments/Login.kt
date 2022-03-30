package com.example.presentation.MainActivity.Login_Registration_Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.app.App
import com.example.domain.LoginStatuses
import com.example.domain.models.Coach_Model
import com.example.domain.models.Consumer_Model
import com.example.presentation.BaceActivity.BaceActivity
import com.example.presentation.MainActivity.MainActivityViewModel
import com.example.presentation.MainActivity.MainActivityViewModelFactory
import com.example.presentation.R
import javax.inject.Inject


class Login : Fragment() {

    @Inject
    lateinit var vmFactory : MainActivityViewModelFactory
    lateinit var  vm : MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity?.applicationContext as App).appComponent.injectVmFactory(this)

        val views = inflater.inflate(R.layout.fragment_login, container, false)
        val Login=   views.findViewById<EditText>(R.id.editTextTextPersonName)
        val  Pass = views.findViewById<EditText>(R.id.editTextTextPassword)

        vm =  ViewModelProvider(this,vmFactory).get(MainActivityViewModel::class.java)

        views.findViewById<Button>(R.id.buttonLogin).setOnClickListener {
                vm.check_user( Login.text.toString(),Pass.text.toString())
        }

        vm.userConsumer.observe(  viewLifecycleOwner )
        {
                userConsumer -> vm.CheckReciavedConsumer(userConsumer)
        }

        vm.userCoach.observe(viewLifecycleOwner)
        {
            userCoach ->vm.CheckReciavedCoach(userCoach)
        }
        vm.LoginStatus.observe(viewLifecycleOwner)
        {
            status ->
            if(status.equals(LoginStatuses.SUCCSESS_CONSUMER) )GotoBaceActivityConsumer(vm.userConsumer.value!!.body()!!)
            if(status.equals(LoginStatuses.SUCCSESS_COACH))GotoBaceActivityCoach(vm.userCoach.value!!.body()!!)
            if(status.equals(LoginStatuses.NO_ACCOUNT)) Toast.makeText(getActivity(), "Ошибка! Введины не верные данные", Toast.LENGTH_SHORT).show()
            if(status.equals(LoginStatuses.SERVER_ERROR))Toast.makeText(getActivity(), "Ошибка! Сервис не доступен", Toast.LENGTH_SHORT).show()
        }
        return views
    }



    fun GotoBaceActivityCoach(coach : ArrayList<Coach_Model>){
        val intent = Intent(getActivity(), BaceActivity::class.java)
        intent.putExtra("Type", "Enter coach")
        intent.putExtra("coach", coach)

        getActivity()?.startActivity(intent)
    }

    fun GotoBaceActivityConsumer(consumer : ArrayList<Consumer_Model>){
        val intent = Intent(getActivity(), BaceActivity::class.java)
        intent.putExtra("Type", "Enter consumer")
        intent.putExtra("consumer", consumer)

        getActivity()?.startActivity(intent)
    }


}