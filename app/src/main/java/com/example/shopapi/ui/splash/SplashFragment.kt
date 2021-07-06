package com.example.shopapi.ui.splash

import android.animation.Animator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shopapi.BaseFragment
import com.example.shopapi.R
import com.example.shopapi.databinding.SplashFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentBinding,SplashViewModel>(SplashFragmentBinding::inflate,SplashViewModel::class.java) {



    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

        binding!!.animView.playAnimation()
        binding!!.animView.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                navigate()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        })



    }


    private fun navigate(){

        if(viewModel.isLoggined()){
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }else{
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }

    }


}