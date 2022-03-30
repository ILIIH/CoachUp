package com.example.presentation.MainActivity.Login_Registration_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.app.App
import com.example.presentation.MainActivity.MainActivityViewModel
import com.example.presentation.MainActivity.MainActivityViewModelFactory
import com.example.presentation.R
import com.google.android.material.textfield.TextInputLayout
import javax.inject.Inject


class RegistartionAsCoach : Fragment() {


    @Inject
    lateinit var vmFactory : MainActivityViewModelFactory
    lateinit var  vm : MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.applicationContext as App).appComponent.injevtVmFactoryRegistrCoach(this)

        val view = inflater.inflate(R.layout.fragment_registartion_as_coach, container, false)
        vm =  ViewModelProvider(this,vmFactory).get(MainActivityViewModel::class.java)

        var enterBtn : Button = view.findViewById(R.id.RegisterCoach)
        var Login : TextView = view.findViewById(R.id.editTextTextLogin)
        var  Pass : TextView = view.findViewById(R.id.editTextTextPassword)
        var Name : TextView = view.findViewById(R.id.editTextTextPersonName)
        var Surname: TextView = view.findViewById(R.id.editTextTextPersonSurName)
        var Expirienceyear: TextView  = view.findViewById(R.id.editTextTextPersonExpirienceyear)
        var PersonAccreditation: TextView = view.findViewById(R.id.editTextTextPersonAccreditation)
        var  Patronimic: TextView  =  view.findViewById(R.id.editTextTextPersonPatronimic)
        var About: TextInputLayout = view.findViewById(R.id.TextInputLayoutAbout)


        enterBtn.setOnClickListener {


        }

        return view
    }

}