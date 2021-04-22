package com.example.stockwatcher.ui.fragments.searchStock

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.example.stockwatcher.R
import com.example.stockwatcher.api.models.LookupApiResponse
import com.example.stockwatcher.databinding.FragmentSearchStockBinding
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class SearchStockFragment : Fragment(), SearchStockNavigator{

    lateinit var binding: FragmentSearchStockBinding
    var searchTextInput: TextInputEditText? = null
    var loadingIndicator: LinearProgressIndicator? = null

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

        var data = ArrayList<String>()

        data.add("ABC")
        data.add("DEF")
        data.add("HIJ")
        data.add("KLM")
        data.add("MNO")
        data.add("PQR")
        data.add("STU")
        data.add("VXYZ")

        return binding.root
    }

    override fun processSearchResults(suggestedTickers: List<LookupApiResponse>) {
        Log.d("Fragment", suggestedTickers.toString())

        hideLoadingIndicator()
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