package com.example.shopapi.ui.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopapi.BaseFragment
import com.example.shopapi.R
import com.example.shopapi.databinding.FavoritesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : BaseFragment<FavoritesFragmentBinding,FavoritesViewModel>(FavoritesFragmentBinding::inflate,FavoritesViewModel::class.java) {


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

    }


}