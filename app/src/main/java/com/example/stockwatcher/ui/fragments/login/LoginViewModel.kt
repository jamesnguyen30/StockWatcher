package com.example.stockwatcher.ui.fragments.login

import android.text.TextUtils
import com.example.stockwatcher.ui.fragments.base.BaseViewModel
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class LoginViewModel : BaseViewModel(){
    fun isValidPassword(password: String): Boolean{
        return TextUtils.isEmpty(password)
    }

    fun authenticateLogin(username: String, password: String): Observable<Boolean> {
       //Mock authentication
        return Observable.just(true).delay(2000, TimeUnit.MILLISECONDS)
    }
}