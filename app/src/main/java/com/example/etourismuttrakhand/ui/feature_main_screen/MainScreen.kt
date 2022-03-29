package com.example.etourismuttrakhand.ui.feature_main_screen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.databinding.FragmentMainScreenBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Data
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Others
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Others.autoScroll
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.TourAdapter
import com.example.etourismuttrakhand.ui.features_favourite.data_source.entities.Place
import com.example.etourismuttrakhand.ui.login_screen.LoginScreen
import kotlinx.android.synthetic.main.fragment_main_screen.*
import kotlinx.android.synthetic.main.fragment_place_details.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

class MainScreen : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private val args:MainScreenArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.name
        val first = name.substringBefore('/')
        val last = name.substringAfter('/')

        val tourAdapter = TourAdapter()
        tourAdapter.differ.submitList(Others.charDham)
        binding.viewPagerDetails2.adapter = tourAdapter
        binding.viewPagerDetails2.autoScroll(1500)
        binding.nameTv.text = "Hey! $first $last"


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




        loadPopularPlaces()

    }

    private fun loadPopularPlaces() {

        val places = ArrayList<Place>()
        var cnt: Int = 0
        while (cnt < 6) {
            val element = Data.dataSource.random()
            if (!places.contains(element)) {
                places.add(element)
                cnt++
            }
        }

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

    private fun searchDestination(q:String):ArrayList<Place>{
        val places = ArrayList<Place>()
        Data.dataSource.forEach {
            if(it.name.startsWith(q))
                places.add(it)
        }
        return places
    }

}