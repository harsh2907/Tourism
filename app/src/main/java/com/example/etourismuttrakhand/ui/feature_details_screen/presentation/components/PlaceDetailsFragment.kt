package com.example.etourismuttrakhand.ui.feature_details_screen.presentation.components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.etourismuttrakhand.databinding.FragmentPlaceDetailsBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.presentation.adapters.DetailsAdapter
import com.example.etourismuttrakhand.ui.feature_details_screen.backend.Others.autoScroll
import com.example.etourismuttrakhand.ui.feature_details_screen.backend.Others.getHomeStay
import com.example.etourismuttrakhand.ui.feature_details_screen.backend.Others.googleMap


class PlaceDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPlaceDetailsBinding
    private val args:PlaceDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaceDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val place = args.place

        //Setting up recycler view
        val detailAdapter = DetailsAdapter()
        detailAdapter.differ.submitList(place.image)
        binding.viewPagerDetails.adapter = detailAdapter
        binding.viewPagerDetails.autoScroll(2000)

        binding.name.text= place.name
        binding.placeDesc.text = place.desc

        binding.homeStay.setOnClickListener {
            requireContext().getHomeStay(place.homeStayId)
        }

        binding.viewHotels.setOnClickListener {
            requireContext().googleMap(place.name)
        }




    }


}