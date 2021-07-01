package com.example.shopapi.extencions

fun String.isEmail()= android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()