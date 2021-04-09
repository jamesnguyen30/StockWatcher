package com.example.stockwatcher.ui.fragments.premium

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.stockwatcher.custom.RoundCornerTransformation
import com.example.stockwatcher.databinding.FragmentPremiumBinding

class PremiumFragment : Fragment() {
    lateinit var binding:FragmentPremiumBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        binding = FragmentPremiumBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Glide.with(this)
            .load("https://m.media-amazon.com/images/I/41JR1zaMQcL.jpg")
            .transform( RoundCornerTransformation(25f))
            .into(binding.premiumImageView)
    }
}