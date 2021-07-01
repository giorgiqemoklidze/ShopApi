package com.example.shopapi.extencions

import android.app.Dialog
import android.view.Window
import android.view.WindowManager


fun Dialog.setUp(resource: Int) {

    window!!.setBackgroundDrawableResource(android.R.color.transparent)
    window!!.requestFeature(Window.FEATURE_NO_TITLE)
    setContentView(resource)
    val params = window!!.attributes
    params.width = WindowManager.LayoutParams.MATCH_PARENT
    params.height = WindowManager.LayoutParams.WRAP_CONTENT

}