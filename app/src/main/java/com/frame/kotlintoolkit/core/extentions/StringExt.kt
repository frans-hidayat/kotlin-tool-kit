package com.frame.kotlintoolkit.core.extentions

import android.util.Patterns
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun String.isEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.toIDR(): String {
    val localeID = Locale("in", "ID")
    var number = this
    if (this.contains("."))
        number = this.replace(".", "")
    val numberFormat = NumberFormat.getCurrencyInstance(localeID)
    numberFormat.minimumFractionDigits = 0
    val doubleValue = number.toDoubleOrNull() ?: return number
    return numberFormat.format(doubleValue)
}

fun String.toCurrencyFormat(): String {
    val formatter: NumberFormat = DecimalFormat("#,###")
    val doubleValue = this.toDoubleOrNull() ?: return this
    return formatter.format(doubleValue)
}

fun String.Companion.empty() = ""