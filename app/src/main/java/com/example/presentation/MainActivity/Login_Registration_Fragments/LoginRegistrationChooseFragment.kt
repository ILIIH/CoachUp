package com.example.presentation.MainActivity.Login_Registration_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.presentation.R


class LoginRegistrationChooseFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val views = inflater.inflate(R.layout.fragment_login_registration, container, false)
        views.findViewById<Button>(R.id.Login).setOnClickListener {

            views.findNavController().navigate(R.id.action_loginRegistrationChooseFragment_to_login)

        }
        views.findViewById<Button>(R.id.RegistrationConsumer).setOnClickListener {

            views.findNavController().navigate(R.id.action_loginRegistrationChooseFragment_to_registration)
        }
        views.findViewById<Button>(R.id.RegistrationAsCoach).setOnClickListener {

            views.findNavController().navigate(R.id.action_loginRegistrationChooseFragment_to_registartionAsCoach)
        }


        return views
    }

}