package com.mycompany.unsplashphoto.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.mycompany.data.models.PhotosItem
import com.mycompany.unsplashphoto.R
import com.mycompany.unsplashphoto.utils.adapters.PhotoAdapter
import com.mycompany.unsplashphoto.databinding.FragementPhotosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : Fragment(R.layout.fragement_photos) {
    private val viewModel: PhotosViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    lateinit var binding: FragementPhotosBinding
    lateinit var photoAdapter: PhotoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragementPhotosBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()
    }

    private fun bindData() {
        viewModel.setPhotos()
        viewModel.photos.observe(viewLifecycleOwner, ::handleSuccess)
        viewModel.loading.observe(viewLifecycleOwner, ::handleLoading)
        viewModel.error.observe(viewLifecycleOwner, ::handleError)
    }

    private fun handleSuccess(it: List<PhotosItem>) {
        val list = it.toList()
        setupRecyclerView()
        photoAdapter.differ.submitList(list)
    }

    private fun handleLoading(flag: Boolean) {
        binding.pbLoading.isVisible = flag
    }

    private fun handleError(error: String) {
        binding.tvError.isVisible = error.isNotEmpty()
    }

    private fun setupRecyclerView() {
        photoAdapter = PhotoAdapter()
        binding.rvPhotos.adapter = photoAdapter
    }
}