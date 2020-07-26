package com.berkayak.myrecentphotos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.berkayak.myrecentphotos.R
import com.berkayak.myrecentphotos.core.utilities.startFragment
import com.berkayak.myrecentphotos.ui.fragment.PhotoListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment(PhotoListFragment.newInstance(), PhotoListFragment.TAG)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            super.onBackPressed()
        } else {
            finish()
        }
    }
}