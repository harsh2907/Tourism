package com.example.etourismuttrakhand.ui.feature_main_screen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.databinding.FragmentMainScreenBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Data
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Others
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Others.autoScroll
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.TourAdapter
import com.example.etourismuttrakhand.ui.features_favourite.data_source.entities.Place
import com.example.etourismuttrakhand.ui.login_screen.LoginScreen
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay


class MainScreen : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel:MainScreenViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setImages()
        setLowerGrid()
        var name = "User"
        viewModel.userName.observe(
            viewLifecycleOwner
        ){
            name = it
    }
        val first = name.substringBefore('/')
        val last = name.substringAfter('/')

        val tourAdapter = TourAdapter()
        tourAdapter.differ.submitList(Others.charDham)
        binding.viewPagerDetails2.adapter = tourAdapter
        binding.viewPagerDetails2.autoScroll(1500)
        binding.nameTv.text = "Hey! $first $last"

        tourAdapter.setOnItemClickedListener {
            val bundle  = Bundle().apply {
                putSerializable("place",it)
            }
            findNavController().navigate(R.id.action_mainScreen_to_placeDetailsFragment,bundle)
        }



        binding.searchInputLayout.isEndIconVisible = binding.searchInputLayout.isFocused

        binding.searchInputLayout.setEndIconOnClickListener {
            binding.searchQuery.text?.clear()
            val keyboard = requireActivity().currentFocus
            if(keyboard !=null){
             val kb =  requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                kb.hideSoftInputFromWindow(keyboard.windowToken,0)
            }
            binding.searchInputLayout.clearFocus()
            binding.searchQuery.clearFocus()
            binding.searchInputLayout.isEndIconVisible = false

        }


        binding.searchQuery.doOnTextChanged { text, _, _, _ ->
            binding.searchInputLayout.isEndIconVisible = true
        }

        binding.searchQuery.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                val ans =  viewModel.searchDestination(v.text.toString())
                val bundle = Bundle().apply { putSerializable("places",ans) }
                findNavController().navigate(R.id.action_mainScreen_to_searchResultFragment,bundle)
                  true
                }
            false
        }

        setImages()
        setLowerGrid()


    }

   private fun setImages(){
        val places = viewModel.loadPopularPlaces()
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
        val places = viewModel.loadPopularPlaces()
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