package com.berkayak.myrecentphotos.ui.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BindableAdapter<T, K : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<K>() {
    abstract fun bindData(data: T)
}