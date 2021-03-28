package com.example.stockwatcher.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.LoginFragmentBinding

class LoginFragment: Fragment(R.layout.login_fragment){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: LoginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        return binding.root
    }
}