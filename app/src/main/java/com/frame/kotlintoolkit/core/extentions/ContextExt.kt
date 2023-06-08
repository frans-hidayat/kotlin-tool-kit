package com.frame.kotlintoolkit.core.extentions

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.showGenericAlertDialog(message: String){
    AlertDialog.Builder(this).apply {
        setMessage(message)
        setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
    }.show()
}