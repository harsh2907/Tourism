package com.example.etourismuttrakhand.ui.feature_details_screen.presentation.components

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.databinding.FragmentSearchResultBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.backend.Data
import com.example.etourismuttrakhand.ui.feature_details_screen.presentation.MainScreenViewModel

class SearchResultFragment : Fragment() {
    private lateinit var binding: FragmentSearchResultBinding
    private val args: SearchResultFragmentArgs by navArgs()
    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val query = args.query

        val places = viewModel.searchDestination(query)

        if (places.isEmpty()) {
            binding.emptyText.visibility = View.VISIBLE
            binding.rvSearchResult.visibility = View.INVISIBLE
        } else {
            binding.emptyText.visibility = View.INVISIBLE
            binding.rvSearchResult.visibility = View.VISIBLE
        }

        val searchAdapter = SearchAdapter()
        searchAdapter.differ.submitList(places)
        binding.rvSearchResult.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvSearchResult.adapter = searchAdapter

        searchAdapter.setOnItemClickedListener {
            val bundle = Bundle().apply {
                putSerializable("place", it)
            }

            findNavController().navigate(
                R.id.action_searchResultFragment_to_placeDetailsFragment,
                bundle
            )


        }
    }
}