package com.example.shopapi.ui.containerFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopapi.BaseFragment
import com.example.shopapi.R
import com.example.shopapi.adapters.drawerRecyclerAdapter
import com.example.shopapi.databinding.ContainerFragmentBinding
import com.example.shopapi.model.DrawerItem
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContainerFragment : BaseFragment<ContainerFragmentBinding,ContainerViewModel>(ContainerFragmentBinding::inflate,ContainerViewModel::class.java) {



    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        initBottomNav()
        initDrawer()

    }

    private fun initBottomNav(){
        val navController = childFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding!!.bottomNav.setupWithNavController(navController.navController)
    }

    private fun initDrawer() {
        val drawerRecyclerAdapter = drawerRecyclerAdapter(
            arrayOf(
                DrawerItem(R.id.action_loginFragment_to_signUpFragment, getString(R.string.sign_out)),


            )
        )
        binding!!.drawerRecycler.apply {
            adapter = drawerRecyclerAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        drawerRecyclerAdapter.click = {
            val navController = requireActivity().supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
            navController.navController.navigate(R.id.action_global_loginFragment)
        }


    }




}