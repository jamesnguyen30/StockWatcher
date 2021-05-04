package com.example.stockwatcher.bindingAdapters

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.stockwatcher.custom.RoundCornerTransformation

class CommonAdapter{
   companion object{
       @BindingAdapter("floatToString")
       @JvmStatic
       fun floatToString(textView: TextView, value: Float){
           textView.text=value.toString()
       }
       @BindingAdapter("imageUrl")
       @JvmStatic
       fun loadImage(imageView: ImageView, imageUrl: String?){
           if(imageUrl!=""){
               Glide.with(imageView.context)
                       .load(imageUrl)
                       .transform(MultiTransformation(CenterCrop(), RoundCornerTransformation(25f)))
                       .into(imageView)
           }
       }
       @BindingAdapter("stockChangeColor")
       @JvmStatic
       fun stockChangeColor(textView: TextView, change: String){
            if(change.first() == '-'){
                textView.setTextColor(Color.RED)
            } else {
                textView.setTextColor(Color.GREEN)
            }
       }
   }

}