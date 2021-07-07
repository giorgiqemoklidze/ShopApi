package com.example.shopapi.ui.containerFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shopapi.BaseFragment
import com.example.shopapi.R
import com.example.shopapi.databinding.ContainerFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContainerFragment : BaseFragment<ContainerFragmentBinding,ContainerViewModel>(ContainerFragmentBinding::inflate,ContainerViewModel::class.java) {


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        initBottomNav()
    }

    private fun initBottomNav(){
        val navController = childFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding!!.bottomNav.setupWithNavController(navController.navController)
    }


}