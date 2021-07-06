package com.example.shopapi.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopapi.BaseFragment
import com.example.shopapi.R
import com.example.shopapi.databinding.HomeFragmentBinding

class HomeFragment : BaseFragment<HomeFragmentBinding,HomeViewModel>(HomeFragmentBinding::inflate,HomeViewModel::class.java) {


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

    }


}