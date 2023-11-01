package com.sceleton.presentation.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<Binding:ViewDataBinding>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
   var binding: Binding? = itemView.let {DataBindingUtil.bind(it)}
}