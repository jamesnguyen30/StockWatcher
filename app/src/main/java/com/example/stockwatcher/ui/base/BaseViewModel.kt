package com.example.stockwatcher.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<T> : ViewModel(){

    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()
    private var navigator:WeakReference<T>? = null;

    override fun onCleared() {
        println("dispose observable")
        mCompositeDisposable.clear()
        super.onCleared()
    }

    fun getCompositeDisposal(): CompositeDisposable{
        return mCompositeDisposable;
    }

    fun addToDisposable(disposable: Disposable){
        mCompositeDisposable.add(disposable)
    }

    fun getNavigator(): T?{
        return navigator!!.get();
    }

    fun setNavigator(navigator: T){
        this.navigator = WeakReference(navigator)
    }
}