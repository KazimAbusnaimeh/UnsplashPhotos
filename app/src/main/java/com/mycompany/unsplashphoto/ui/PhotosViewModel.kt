package com.mycompany.unsplashphoto.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycompany.data.models.Photos
import com.mycompany.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

     val photos: MutableLiveData<Photos> = MutableLiveData()

     fun setPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            photos.postValue(repository.getPhotos())
        }
    }
}