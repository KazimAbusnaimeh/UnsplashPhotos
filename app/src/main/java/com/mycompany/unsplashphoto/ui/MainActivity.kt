package com.mycompany.unsplashphoto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mycompany.unsplashphoto.databinding.ActivityMainBinding
import com.mycompany.unsplashphoto.datasource.Api
import com.mycompany.unsplashphoto.mudel.Photos
import com.mycompany.unsplashphoto.utils.Constants.BASE_URL
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)

        api.getPhotos().enqueue(object : Callback<Photos?> {
            override fun onResponse(call: Call<Photos?>, response: Response<Photos?>) {
                binding.tvMain.text=response.body()!![4].urls.regular
            }

            override fun onFailure(call: Call<Photos?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}