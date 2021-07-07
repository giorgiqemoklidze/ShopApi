package com.example.shopapi.ui.orders


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shopapi.BaseFragment
import com.example.shopapi.databinding.OrdersFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : BaseFragment<OrdersFragmentBinding, OrdersViewModel>(
    OrdersFragmentBinding::inflate,
    OrdersViewModel::class.java) {

    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

    }


}