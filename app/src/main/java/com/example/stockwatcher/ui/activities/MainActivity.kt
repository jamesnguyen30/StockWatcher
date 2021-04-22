package com.example.stockwatcher.ui.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.ActivityMainBinding
import com.example.stockwatcher.ui.fragments.runningStock.RunningStockFragment
import com.example.stockwatcher.ui.fragments.searchStock.SearchStockFragment
import com.example.stockwatcher.ui.fragments.watching.WatchingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val bottomNavigationView = binding.bottomNavigationView

        val navController = findNavController(R.id.main_nav_host_fragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            var fragment = navController.currentDestination
            when(it.itemId){
                R.id.newsItem -> {
                    if(fragment!!.id != R.id.newsFragment){
                        navController.navigate(R.id.action_searchStockFragment_pop)
                        enableRunningFragment(true)
                    }
                    true
                }
                R.id.searchItem -> {
                    if(fragment!!.id != R.id.searchStockFragment){
                        navController.navigate(R.id.action_newsFragment_to_searchStockFragment)
                        enableRunningFragment(false)
                    }
                    true
                }
                R.id.watchItem ->{
                    startWatchingFragment()
                    true
                }
                R.id.headlineItem ->{
                    true
                }
                else -> false
            }
        }
    }

    fun startWatchingFragment(){
        //Bring up BottomSheetView
        var watchingFragment = WatchingFragment()
        this.supportFragmentManager.let{
            watchingFragment.show(it, "WatchingFragment")
        }
    }

    fun enableRunningFragment(isEnabled: Boolean){
        this.supportFragmentManager.let{
            var runningStockFragment = it.findFragmentById(R.id.running_stock_fragment)
            var transaction = it.beginTransaction()
            var isHidden = runningStockFragment!!.isHidden
            if(isEnabled && isHidden) {
               transaction.show(runningStockFragment)
            } else {
                transaction.hide(runningStockFragment)
            }
            transaction.commit()
        }
    }
}