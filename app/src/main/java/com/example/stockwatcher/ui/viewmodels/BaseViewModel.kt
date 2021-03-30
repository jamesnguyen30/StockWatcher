package com.example.stockwatcher.ui.viewmodels

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

//the line below will be usued when Navigator is implemented
//abstract class BaseViewModel<T> : ViewModel(){
abstract class BaseViewModel : ViewModel(){

    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        mCompositeDisposable.clear()
        super.onCleared()
    }

    fun getCompositeDisposal(): CompositeDisposable{
        return mCompositeDisposable;
    }

    fun addToDisposable(disposable: Disposable){
        mCompositeDisposable.add(disposable)
    }
}