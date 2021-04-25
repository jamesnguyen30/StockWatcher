package com.example.stockwatcher.ui.fragments.searchStock

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stockwatcher.api.models.IEXSearchApiResponse
import com.example.stockwatcher.databinding.FragmentSearchStockBinding
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class SearchStockFragment : Fragment(), SearchStockNavigator{

    lateinit var binding: FragmentSearchStockBinding
    var searchTextInput: TextInputEditText? = null
    var loadingIndicator: LinearProgressIndicator? = null
    var recyclerViewAdapter: SearchStockAdapter? = null

    var viewModel: SearchStockViewModel = SearchStockViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentSearchStockBinding.inflate(inflater, container, false)

        viewModel.init(this)
        searchTextInput = binding.searchTextInputAutocomplete

        loadingIndicator = binding.tickerAutocompleteLoadIndicator

        searchTextInput!!.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                showLoadingIndicator()
                viewModel.lookupTicker(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        recyclerViewAdapter = SearchStockAdapter(binding.root.context)
        val recyclerView = binding.searchResultsRecyclerView
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun processSearchResults(suggestedIEXSearches: List<IEXSearchApiResponse>) {
        Log.d("Fragment", suggestedIEXSearches.toString())
        hideLoadingIndicator()
        recyclerViewAdapter!!.updateDataStore(suggestedIEXSearches)
    }

    override fun showLoadingIndicator() {
        if(loadingIndicator!!.visibility !=View.VISIBLE){
            loadingIndicator!!.visibility = View.VISIBLE
        }
    }

    override fun hideLoadingIndicator() {
        if(loadingIndicator!!.visibility !=View.INVISIBLE){
            loadingIndicator!!.visibility = View.INVISIBLE
        }
    }

    override fun requestError() {
        //TODO: Display error
    }

}