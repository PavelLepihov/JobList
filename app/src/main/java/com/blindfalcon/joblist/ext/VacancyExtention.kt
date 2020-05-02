package com.blindfalcon.joblist.ext

import android.content.Context
import com.blindfalcon.joblist.R
import com.blindfalcon.joblist.data.repos.entity.Vacancy

fun Vacancy.getSalary(context : Context): String {
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

fun Vacancy.getDate() : String {
    val sdf = java.text.SimpleDateFormat("dd-MM-yyyy", java.util.Locale.ENGLISH)
    val date = java.util.Date(date.toLong() * 1000)
    return sdf.format(date)
}

fun Vacancy.getMetro(context : Context) : String =
    if (metro.isNotEmpty()) {
        context.getString(R.string.metro_text) + " " + metro[0].metroTitle
    } else {
        ""
    }