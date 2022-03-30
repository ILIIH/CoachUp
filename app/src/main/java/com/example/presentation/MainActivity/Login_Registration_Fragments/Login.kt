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
    var g = 0
        vm.userConsumer.observe(  viewLifecycleOwner

        ) { observant ->

            when (observant.code()) {
                in 500..599 -> Toast.makeText(
                    getActivity(),
                    "Ошибка! Сервис не доступен",
                    Toast.LENGTH_SHORT
                ).show()
                in 400..499 -> Toast.makeText(
                    getActivity(),
                    "Ошибка! Клиентская ошибка",
                    Toast.LENGTH_SHORT
                ).show()
                in 200..299 -> {
                    if (observant.body() == null) Toast.makeText(
                        getActivity(),
                        "Ошибка! Введины не верные данные",
                        Toast.LENGTH_SHORT
                    ).show()
                    else if(observant.body()!!.isEmpty())Toast.makeText(
                        getActivity(),
                        "Ошибка! Введины не верные данные",
                        Toast.LENGTH_SHORT
                    ).show()
                    else GotoBaceActivity()
                }
            }
        }

        return views
    }

    fun GotoBaceActivity(){
        val intent = Intent(getActivity(), BaceActivity::class.java)
        intent.putExtra("Type", "Enter")
       // intent.putExtra("Password", Pass.text.toString())
       // intent.putExtra("Login", Login.text.toString())
        getActivity()?.startActivity(intent)
    }


}