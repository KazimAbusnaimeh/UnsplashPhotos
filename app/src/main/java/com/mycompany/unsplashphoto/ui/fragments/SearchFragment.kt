package com.mycompany.unsplashphoto.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import com.mycompany.unsplashphoto.R
import com.mycompany.unsplashphoto.adapters.PhotoAdapter
import com.mycompany.unsplashphoto.databinding.FragementSearchBinding
import com.mycompany.unsplashphoto.ui.PhotosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: Fragment(R.layout.fragement_search) {
    private val viewModel:PhotosViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    lateinit var binding: FragementSearchBinding
    lateinit var photoAdapter: PhotoAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragementSearchBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectData()
        viewModel.setPhotos()
        viewModel.photos.observe(viewLifecycleOwner, Observer {
            binding.tvMain.text=it[0].color
        })
    }

    private fun connectData(){
        viewModel.setPhotos()
        viewModel.photos.observe(viewLifecycleOwner, Observer {
            val list=it.toList()
            setRecyclerView()
            photoAdapter.differ.submitList(list)
        })
    }

    private fun setRecyclerView(){
        photoAdapter= PhotoAdapter()
        binding.rvSearch.apply {
            adapter=photoAdapter
        }
    }
}