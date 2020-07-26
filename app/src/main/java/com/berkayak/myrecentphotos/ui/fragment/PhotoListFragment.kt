package com.berkayak.myrecentphotos.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.berkayak.myrecentphotos.R
import com.berkayak.myrecentphotos.core.utilities.Const
import com.berkayak.myrecentphotos.data.model.GenericResponse
import com.berkayak.myrecentphotos.databinding.FragmentPhotoListBinding
import com.berkayak.myrecentphotos.ui.adapter.PhotoAdapter
import com.berkayak.myrecentphotos.ui.bindable.PhotoListFragmentProps
import com.berkayak.myrecentphotos.viewmodel.RecentPhotoListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotoListFragment : Fragment() {

    private lateinit var binding: FragmentPhotoListBinding
    private val photoListViewModel by viewModel<RecentPhotoListViewModel>()
    private var props = PhotoListFragmentProps()
    private var adapter: PhotoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_list, container, false)
        binding.props = props
        binding.rvPhotos.layoutManager = GridLayoutManager(context, 2)
        adapter = photoListViewModel.createAdapter(activity).apply {
            binding.rvPhotos.adapter = this
        }
        setPhotoListObserver()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoListViewModel.getRecentPhotos()
    }

    private fun setPhotoListObserver() {
        photoListViewModel.observeRecentPhotos().observe(this, Observer { response ->
            when (response) {
                is GenericResponse.Success -> {
                    Log.d(Const.LOG_TAG, "setPhotoListObserver: success")
                    response.result?.photos?.photo?.let { safeList ->
                        props.photoList = props.photoList + safeList
                    }
                    props.pageInfo =
                        "${props.photoList.size} items in ${photoListViewModel.currentPage} page"
                }
                is GenericResponse.Failure -> {
                    Log.d(Const.LOG_TAG, "setPhotoListObserver: fail -> \n ${response.message}")
                }
                is GenericResponse.Error -> {
                    Log.d(
                        Const.LOG_TAG,
                        "setPhotoListObserver: error -> \n ${response.exception.localizedMessage}"
                    )
                }
            }
        })
    }

    companion object {
        const val TAG = "PhotoListFragment"

        fun newInstance() = PhotoListFragment()
    }
}