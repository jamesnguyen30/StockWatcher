package com.example.stockwatcher.ui.activities

import android.app.Dialog
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.ActivityLoginBinding
import com.example.stockwatcher.ui.fragments.news.NewsFragmentBottomSheet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class LoginActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
    }

    fun configure(fragment: NewsFragmentBottomSheet){
    }


}
