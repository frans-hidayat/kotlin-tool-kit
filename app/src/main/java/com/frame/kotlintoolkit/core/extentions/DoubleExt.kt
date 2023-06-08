package com.frame.kotlintoolkit.core.extentions

import java.text.NumberFormat
import java.util.*

fun Double?.toIDR(): String {
    val localeID = Locale("in", "ID")
    val numberFormat = NumberFormat.getCurrencyInstance(localeID)
    numberFormat.minimumFractionDigits = 0

    val doubleValue = this ?: return "0"
    return numberFormat.format(doubleValue)
}