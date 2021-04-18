package com.example.stockwatcher.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

//        val bottomNavigationView = binding.bottomNavigationView
//        val navController = findNavController(R.id.main_nav_host_fragment)

//        bottomNavigationView.setupWithNavController(navController)
    }
}