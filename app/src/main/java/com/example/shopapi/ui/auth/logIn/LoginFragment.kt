package com.example.shopapi.ui.auth.logIn


import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.shopapi.BaseFragment
import com.example.shopapi.R
import com.example.shopapi.databinding.LoginFragmentBinding
import com.example.shopapi.extencions.isEmail
import com.example.shopapi.extencions.setUp
import com.example.shopapi.network.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginFragmentBinding, LoginViewModel>(
    LoginFragmentBinding::inflate,
    LoginViewModel::class.java
) {


    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        setListeners()

    }


    private fun setListeners() {
        binding!!.logInBtn.setOnClickListener {
            logIn()
            observes()
        }
        binding!!.forgetBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

    }

    private fun logIn() {

        val email = binding!!.email.text.toString().trim()
        val password = binding!!.password.text.toString().trim()
        val rememberMe = binding!!.rememberMe.isChecked

        if (email.isNotBlank() && password.isNotBlank()) {

            if (email.isEmail()) {
                viewModel.logIn(email, password, rememberMe)
            } else {
                showErrorDialog(getString(R.string.error), "email is incorrect")
            }

        } else {
            showErrorDialog(getString(R.string.error), getString(R.string.missing_fields))
        }


    }

    private fun isEmailValid(text: String) {

        if (text.isEmail()) {

        } else {
            showErrorDialog(getString(R.string.error), getString(R.string.missing_fields))
        }
    }


    private fun observes() {
        viewModel._logInLiveData.observe(viewLifecycleOwner, {

            when (it.status) {

                Resource.Status.Succsess -> {
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }
                Resource.Status.Error -> {
                    it.message?.let { it1 -> showErrorDialog(getString(R.string.error), it1) }
                }

            }

        })
    }


    fun showErrorDialog(title: String, description: String) {
        val dialog = Dialog(requireContext())
        dialog.setUp(R.layout.dialog)
        dialog.findViewById<TextView>(R.id.dialogTitle).text = title
        dialog.findViewById<TextView>(R.id.dialogDescription).text = description
        dialog.findViewById<Button>(R.id.continuee).setOnClickListener {
            dialog.cancel()
        }
        dialog.show()
    }


}