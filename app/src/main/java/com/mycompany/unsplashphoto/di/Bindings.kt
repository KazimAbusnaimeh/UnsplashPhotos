package com.mycompany.unsplashphoto.di

import android.content.res.Resources
import android.content.res.loader.ResourcesProvider
import android.graphics.drawable.Drawable
import android.text.Layout
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.compose.animation.VectorConverter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.Resource
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

@BindingAdapter("app:background")
fun background(layout: View, boolean: String) {
    val int=  android.graphics.Color.parseColor(boolean)
   layout.setBackgroundColor(int)
}

@BindingAdapter("app:dateText")
fun dateText(view: TextView, text: String) {
   val sText=text.split("T")
    val date=sText[0]
    view.text="$date"
}


