package com.example.shopapi.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopapi.BaseFragment
import com.example.shopapi.adapters.postsRecyclerAdapter
import com.example.shopapi.databinding.FragmentHomeBinding
import com.example.shopapi.model.Posts
import com.example.shopapi.network.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate,
    HomeViewModel::class.java) {

    private lateinit var adapter : postsRecyclerAdapter

    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

        init()

    }

    private fun init(){

        viewModel.getPost()
        initRecycler()
        observe()
        setListeners()

    }



    private fun initRecycler() {
        adapter = postsRecyclerAdapter()
        binding!!.postsRecycler.layoutManager = LinearLayoutManager(context)
        binding!!.postsRecycler.adapter = adapter
    }


    private fun setListeners() {

        binding!!.swipeRefresh.setOnRefreshListener {
            viewModel.getPost()
        }

    }

    private fun observe() {

        viewModel.postLiveData.observe(viewLifecycleOwner, {
            binding!!.swipeRefresh.isRefreshing = it.loading

            when (it.status) {
                Resource.Status.Succsess -> {
                    adapter.setData(it.data as MutableList<Posts>)
                }
            }


        })

    }


}