package com.example.shopapi.login


import android.util.Patterns
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shopapi.BaseFragment
import com.example.shopapi.databinding.LoginFragmentBinding

class LoginFragment : BaseFragment<LoginFragmentBinding, LoginViewModel>(
    LoginFragmentBinding::inflate,
    LoginViewModel::class.java
) {


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }


    private fun init() {
        btnClicks()
    }

    private fun btnClicks() {
        binding?.logInBtn?.setOnClickListener { logIn() }
    }

    private fun logIn() {

        if (binding?.email?.text.toString().trim().isEmpty()) {
            binding?.email?.error = "sheiyvanet Email"
            binding?.email?.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(binding?.email?.text.toString().trim()).matches()) {
            binding?.email?.error = "sheiyvanet swori Email"
            binding?.email?.requestFocus()
            return
        }
        if (binding?.password?.text.toString().trim().isEmpty()) {
            binding?.password?.error = "sheiyvanet Password"
            binding?.password?.requestFocus()
            return
        }



        if (binding?.password?.text.toString().trim().length < 6) {
            binding?.password?.error = "sheiyvanet minimum 6 simbolo"
            binding?.password?.requestFocus()
            return
        }

        viewModel.logIn(
            binding?.email?.text.toString().trim(),
            binding?.password?.text.toString().trim()
        )

    }


}