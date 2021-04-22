package com.example.stockwatcher.ui.fragments.searchStock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.stockwatcher.R
import com.example.stockwatcher.databinding.FragmentSearchStockBinding
import com.google.android.material.textfield.TextInputEditText

class SearchStockFragment : Fragment(), SearchStockNavigator, View.OnClickListener{

    lateinit var binding: FragmentSearchStockBinding
    lateinit var searchTextInput: TextInputEditText

    var viewModel: SearchStockViewModel = SearchStockViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentSearchStockBinding.inflate(inflater, container, false)

        var testButton = binding.testButton
        testButton.setOnClickListener(this)

        viewModel.setNavigator(this)
        searchTextInput = binding.searchTextInputAutocomplete

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

    override fun processSearchResults() {
        //TODO: implement
    }

    override fun loadingRequest() {
        TODO("Not yet implemented")
    }

    override fun stopLoadingRequest() {
        TODO("Not yet implemented")
    }

    override fun requestError() {
        TODO("Not yet implemented")
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.testButton ->{
               //TODO: Implement when text is entered
                viewModel.lookupTicker(searchTextInput.text.toString())
            }
        }
    }
}