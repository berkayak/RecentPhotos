package com.berkayak.myrecentphotos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berkayak.myrecentphotos.R
import com.berkayak.myrecentphotos.core.utilities.startFragment
import com.berkayak.myrecentphotos.ui.fragment.PhotoListFragment

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    startFragment(PhotoListFragment(), "BERKAY")
  }
}