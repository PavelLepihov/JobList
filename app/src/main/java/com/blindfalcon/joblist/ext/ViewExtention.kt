package com.blindfalcon.joblist.ext

import android.view.View.VISIBLE
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.inTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction()
        .function()
        .commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag: String? = null) {
    supportFragmentManager.inTransaction {
        replace(frameId, fragment, tag)
    }
}

fun Fragment.replaceChildFragment(fragment: Fragment, frameId: Int, tag: String? = null) {
    childFragmentManager.inTransaction {
        replace(frameId, fragment, tag)
    }
}

fun TextView.switchOnSetText(text: String?) {
    visibility = VISIBLE
    this.text = text
}