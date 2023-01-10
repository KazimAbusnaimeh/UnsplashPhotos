package com.mycompany.unsplashphoto.bindingadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mycompany.unsplashphoto.R


@BindingAdapter("app:photo")
fun photo(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .centerCrop()
        .error(R.drawable.ic_launcher_background)
        .into(imageView)
}


