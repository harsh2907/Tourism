package com.example.etourismuttrakhand.ui.feature_details_screen.presentation.components

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.etourismuttrakhand.R
import androidx.appcompat.widget.SearchView
import com.example.etourismuttrakhand.databinding.FragmentMainScreenBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.presentation.adapters.DetailAdapter
import com.example.etourismuttrakhand.ui.feature_details_screen.backend.Data
import com.example.etourismuttrakhand.ui.feature_details_screen.backend.Others
import com.example.etourismuttrakhand.ui.feature_details_screen.backend.Others.autoScroll
import com.example.etourismuttrakhand.ui.feature_details_screen.presentation.adapters.TourAdapter
import com.example.etourismuttrakhand.ui.feature_details_screen.presentation.MainScreenViewModel


class MainScreen : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel: MainScreenViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setImages()
        setLowerGrid()

        val sharedPref = requireContext().getSharedPreferences("Login", Context.MODE_PRIVATE)
        val name = sharedPref.getString("name","")

        val tourAdapter = TourAdapter()
        tourAdapter.differ.submitList(Others.charDham)
        binding.rvCharDham.adapter = tourAdapter
        binding.rvCharDham.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val detailAdapter = DetailAdapter()
        detailAdapter.differ.submitList(Data.whyVisit)
        binding.whyVisitViewpager.adapter = detailAdapter
        binding.whyVisitViewpager.autoScroll(4000)

        tourAdapter.setOnItemClickedListener {
            val bundle  = Bundle().apply {
                putSerializable("place",it)
            }
            findNavController().navigate(R.id.action_mainScreen_to_placeDetailsFragment,bundle)
        }


       binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
           override fun onQueryTextSubmit(query: String?): Boolean {

               query?.let { q->
                   if(q.isNotEmpty()){
                       val bundle = Bundle().apply {
                           putString("query",q)
                       }
                       findNavController().navigate(R.id.action_mainScreen_to_searchResultFragment4,bundle)
                   }
               }
               return true
           }

           override fun onQueryTextChange(newText: String?): Boolean {
               return false
           }

       } )


        setImages()
        setLowerGrid()


    }

   private fun setImages(){
        val places = Data.allPlaces
        binding.popular1.setImageResource(places.elementAt(0).image.random())
        binding.popularName1.text = places[0].name
        binding.popular2.setImageResource(places.elementAt(1).image.random())
        binding.popularName2.text = places[1].name
        binding.popular3.setImageResource(places.elementAt(2).image.random())
        binding.popularName3.text = places[2].name
        binding.popular4.setImageResource(places.elementAt(3).image.random())
        binding.popularName4.text = places[3].name
        binding.popular5.setImageResource(places.elementAt(4).image.random())
        binding.popularName5.text = places[4].name
        binding.popular6.setImageResource(places.elementAt(5).image.random())
        binding.popularName6.text = places[5].name
    }

   private fun setLowerGrid(){
        val places = Data.allPlaces
        binding.popularCard1.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("place",places[0])
            }
            findNavController().navigate(R.id.action_mainScreen_to_placeDetailsFragment,bundle)
        }
        binding.popularCard2.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("place",places[1])
            }
            findNavController().navigate(R.id.action_mainScreen_to_placeDetailsFragment,bundle)
        }
        binding.popularCard3.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("place",places[2])
            }
            findNavController().navigate(R.id.action_mainScreen_to_placeDetailsFragment,bundle)
        }
        binding.popularCard4.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("place",places[3])
            }
            findNavController().navigate(R.id.action_mainScreen_to_placeDetailsFragment,bundle)
        }
        binding.popularCard5.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("place",places[4])
            }
            findNavController().navigate(R.id.action_mainScreen_to_placeDetailsFragment,bundle)
        }
        binding.popularCard6.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("place",places[5])
            }
            findNavController().navigate(R.id.action_mainScreen_to_placeDetailsFragment,bundle)
        }
    }





}