package com.blindfalcon.joblist.ext

import android.content.Context
import com.blindfalcon.joblist.R
import com.blindfalcon.joblist.data.repos.entity.Vacancy
import java.text.SimpleDateFormat
import java.util.*

fun Vacancy.getSalary(context: Context): String {
    var salary = ""
    if (paymentFrom == 0 && paymentTo == 0) {
        salary = context.getString(R.string.salary_empty_text)
    } else if (paymentFrom > 0 && paymentTo == 0) {
        salary = context.getString(R.string.salary_from_text) + " " + paymentFrom
    } else if (paymentFrom == 0 && paymentTo > 0) {
        salary = context.getString(R.string.salary_to_text) + " " + paymentTo
    } else if (paymentFrom > 0 && paymentTo > 0) {
        salary = """$paymentFrom - $paymentTo"""
    }
    return salary
}

fun Vacancy.getDate(): String {
    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
    val date = Date(date.toLong() * 1000)
    return sdf.format(date)
}

fun Vacancy.getMetro(): String =
    if (metro.isNotEmpty()) {
        metro.joinToString(", ") { it.metroTitle }
    } else {
        ""
    }