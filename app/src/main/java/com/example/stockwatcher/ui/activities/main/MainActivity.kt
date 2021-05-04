package com.example.stockwatcher.ui.activities.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.stockwatcher.R
import com.example.stockwatcher.api.models.StockQuote
import com.example.stockwatcher.databinding.ActivityMainBinding
import com.example.stockwatcher.ui.fragments.watching.WatchingFragment

class MainActivity : AppCompatActivity(), MainNavigator {
    lateinit var binding: ActivityMainBinding
    private var watchList: ArrayList<String>? = null;

    var mainViewModel = MainViewModel()

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

        loadSavedWatchList()

        if(watchList!=null && watchList!!.size != 0){
            mainViewModel.setNavigator(this)
            mainViewModel.symbolList = watchList!!.toList()
            mainViewModel.startFetchingData()
        }

        mainViewModel.stockQuoteLiveData.observe(this,
                Observer<Map<String, StockQuote>> {
            Toast.makeText(this@MainActivity, "Quote is updated", Toast.LENGTH_SHORT).show()
        })
    }

    fun startWatchingFragment(){
        //Bring up BottomSheetView
        var watchingFragment = WatchingFragment()
        this.supportFragmentManager.let{
            watchingFragment.show(it, "WatchingFragment")
        }
    }

    private fun loadSavedWatchList(){
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?:return
        with(sharedPref){
            val key = resources.getString(R.string.saved_watch_list_shared_preference_key)
            val savedWatchList = getStringSet(key, null) ?: HashSet<String>()

            if(savedWatchList.isEmpty()){
                savedWatchList.add("AAPL")
                savedWatchList.add("AMZN")
                savedWatchList.add("TSLA")
                savedWatchList.add("DJI")
                savedWatchList.add("IXIC")
                savedWatchList.add("GM")
                savedWatchList.add("DIS")

                with(sharedPref.edit()){
                    putStringSet(key, savedWatchList)
                    apply()
                }
            }

            watchList = ArrayList(savedWatchList)
        }
    }

    fun getWatchList():ArrayList<String>? {
        return watchList
    }

    fun addToWatchList(ticker: String): Boolean{
        val sharedPrefs = this.getPreferences(Context.MODE_PRIVATE) ?: return false
        val key = resources.getString(R.string.saved_watch_list_shared_preference_key)
        with(sharedPrefs.edit()){

            putStringSet(key, HashSet<String>(watchList))
            apply()
        }
        return true
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

    override fun stockDataIsUpdated() {
//        Toast.makeText(this, "Stock is Updated", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadingIndicator() {
        TODO("Not yet implemented")
    }

    override fun hideLoadingIndicator() {
        TODO("Not yet implemented")
    }

    override fun requestError() {
        TODO("Not yet implemented")
    }
}