package com.mycompany.unsplashphoto.di

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mycompany.unsplashphoto.R
import java.net.URL


@BindingAdapter("app:photo")
fun photo(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .centerCrop()
        .error(R.drawable.ic_launcher_background)
        .into(imageView)
}

@BindingAdapter("app:liked")
fun liked(imageView: ImageView, boolean: Boolean) {
    if (boolean) {
        imageView.setImageResource(R.drawable.ic_liked)
    } else
        imageView.setImageResource(R.drawable.ic_unliked)
}
