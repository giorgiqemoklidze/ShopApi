package com.example.shopapi.auth.signUp

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.shopapi.BaseFragment
import com.example.shopapi.R
import com.example.shopapi.databinding.SignUpFragmentBinding
import com.example.shopapi.extencions.isEmail
import com.example.shopapi.extencions.setUp
import com.example.shopapi.network.Resource

class SignUpFragment : BaseFragment<SignUpFragmentBinding, SignUpViewModel>(
    SignUpFragmentBinding::inflate,
    SignUpViewModel::class.java
) {

    override fun start(inflater: LayoutInflater, container: ViewGroup?) {

        init()
    }

    private fun init() {

        observes()
        listeners()

    }


    private fun listeners() {

        binding!!.signUpBtn.setOnClickListener {
            signUp()
        }

        binding!!.logInBtn.setOnClickListener {
            findNavController().navigateUp()
        }


    }


    private fun signUp() {

        val email = binding!!.email.text.toString().trim()
        val password = binding!!.password.text.toString().trim()
        val fullname = binding!!.fullName.text.toString().trim()


        if (email.isNotBlank() && password.isNotBlank()) {

            if (email.isEmail()) {
                viewModel.signUp(email, fullname, password)
            } else {
                showErrorDialog(getString(R.string.error), "email is incorrect")
            }

        } else {
            showErrorDialog(getString(R.string.error), getString(R.string.missing_fields))
        }


    }


    private fun observes() {
        viewModel._signUpLiveData.observe(viewLifecycleOwner, {

            when (it.status) {

                Resource.Status.Succsess -> {

                }
                Resource.Status.Error -> {
                    showErrorDialog(getString(R.string.error), it.message!!)
                }

            }

        })
    }


    fun showErrorDialog(title: String, description: String) {
        val dialog = Dialog(requireContext())
        dialog.setUp(R.layout.dialog)
        dialog.findViewById<TextView>(R.id.dialogTitle).text = title
        dialog.findViewById<TextView>(R.id.dialogDescription).text = description
        dialog.show()
    }


}