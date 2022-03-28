package com.example.etourismuttrakhand.ui.feature_details_screen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.databinding.FragmentPlaceDetailsBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Others.autoScroll
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Others.badrinathList
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.TourAdapter


class PlaceDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPlaceDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaceDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val tourAdapter = TourAdapter()
        tourAdapter.differ.submitList(badrinathList)
        binding.viewPagerDetails.adapter = tourAdapter
        binding.viewPagerDetails.autoScroll(1800)

        binding.openingClosingDetails.isSelected = true


    }


}