package com.example.shopapi.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shopapi.BaseFragment
import com.example.shopapi.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate,
    HomeViewModel::class.java) {


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

    }


}