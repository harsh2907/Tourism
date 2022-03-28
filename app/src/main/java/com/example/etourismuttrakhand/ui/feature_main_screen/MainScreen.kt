package com.example.etourismuttrakhand.ui.feature_main_screen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.databinding.FragmentMainScreenBinding
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Others
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Others.autoScroll
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.TourAdapter
import com.example.etourismuttrakhand.ui.login_screen.LoginScreen
import kotlinx.android.synthetic.main.fragment_main_screen.*

class MainScreen : Fragment() {

private lateinit var binding:FragmentMainScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tourAdapter = TourAdapter()
        tourAdapter.differ.submitList(Others.charDham)
        binding.viewPagerDetails2.adapter = tourAdapter
        binding.viewPagerDetails2.autoScroll(1500)


    }

}