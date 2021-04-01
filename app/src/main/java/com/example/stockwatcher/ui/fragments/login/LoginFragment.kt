package com.example.stockwatcher.ui.fragments.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.FragmentLoginBinding
import com.example.stockwatcher.ui.activities.MainActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginFragment: Fragment(R.layout.fragment_login), View.OnClickListener{

    var navController: NavController?=null
    lateinit var binding: FragmentLoginBinding

    var viewModel: LoginViewModel = LoginViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            val observable = viewModel.authenticateLogin("name", "password")
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .doOnNext{
                    binding.progressBar.visibility = View.INVISIBLE
                }
                .subscribe({
                    handleResponse(view.context, it)
                }, {
                    handleError(view.context, it)
                })
            viewModel.addToDisposable(observable)
        }

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.register_button).setOnClickListener(this);
        view.findViewById<Button>(R.id.testButton).setOnClickListener(this);
    }

    override fun onClick(v: View?) {
       when(v!!.id){
           R.id.register_button-> navController!!.navigate(R.id.action_loginFragment_to_registerFragment)
           R.id.testButton-> {
               println("Starting main activity")
               //Start main activity
               val intent = Intent(v!!.context, MainActivity::class.java)
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
               startActivity(intent)
           }
       }
    }

    fun handleResponse(context: Context, isAuthenticated: Boolean){
        if(isAuthenticated){
            Toast.makeText(context, "Login Successful", LENGTH_SHORT)
        } else {
            Toast.makeText(context, "Login Failed", LENGTH_SHORT)
        }
    }

    fun handleError(context: Context, error: Throwable){
        Toast.makeText(context, "Error: $error", LENGTH_SHORT)
    }
}