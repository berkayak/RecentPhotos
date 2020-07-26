package com.berkayak.myrecentphotos.core.utilities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.berkayak.myrecentphotos.R
import com.berkayak.myrecentphotos.ui.MainActivity

fun FragmentActivity.startFragment(fragment: Fragment, tag: String) {

    (this as? MainActivity)?.apply {
        this.supportFragmentManager.beginTransaction().add(
            R.id.flFragmentContainer,
            fragment,
            tag
        )
            .addToBackStack(tag)
            .commit()
    }
}