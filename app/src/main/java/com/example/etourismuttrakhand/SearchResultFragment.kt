package com.example.etourismuttrakhand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.etourismuttrakhand.databinding.FragmentSearchResultBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Data
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.TourAdapter
import com.example.etourismuttrakhand.ui.search_features.SearchAdapter

class SearchResultFragment : Fragment() {
 private lateinit var binding:FragmentSearchResultBinding
 private val args:SearchResultFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val places = args.places
        val tourAdapter = SearchAdapter()
        tourAdapter.differ.submitList(Data.allPlaces)
        binding.rvSearchResult.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rvSearchResult.adapter = tourAdapter


        if (places.places.isEmpty()) binding.emptyText.visibility = View.VISIBLE else View.INVISIBLE



    }
}