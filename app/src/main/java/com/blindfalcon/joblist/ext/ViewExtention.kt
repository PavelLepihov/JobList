package com.blindfalcon.joblist.ext

import android.content.Context
import android.view.View
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
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

fun EditText.hideSoftKeyboardOnFocusLostEnabled(enabled: Boolean) {
    val listener = if (enabled) OnFocusLostListener() else null
    onFocusChangeListener = listener
}

class OnFocusLostListener: View.OnFocusChangeListener {
    override fun onFocusChange(v: View, hasFocus: Boolean) {
        if (!hasFocus) {
            val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }
}