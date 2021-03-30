package com.example.stockwatcher.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.FragmentLoginBinding

class LoginFragment: Fragment(R.layout.fragment_login), View.OnClickListener{

    var navController: NavController?=null;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.login_button).setOnClickListener(this);
        view.findViewById<Button>(R.id.stock_list_button).setOnClickListener(this);
        view.findViewById<Button>(R.id.register_button).setOnClickListener(this);
        view.findViewById<Button>(R.id.profile_button).setOnClickListener(this);
    }

    override fun onClick(v: View?) {
       when(v!!.id){
           R.id.login_button -> navController!!.navigate(R.id.action_loginFragment_to_profileFragment)
           R.id.profile_button -> navController!!.navigate(R.id.action_loginFragment_to_profileFragment)
           R.id.stock_list_button -> navController!!.navigate(R.id.action_loginFragment_to_stockListFragment)
           R.id.register_button-> navController!!.navigate(R.id.action_loginFragment_to_registerFragment)
       }
    }
}