package com.project.consultcep.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.project.consultcep.domain.model.CepHistoryTable

@BindingAdapter("cepCode")
fun TextView.setCepCode(item: CepHistoryTable){
    text = item.cepCode
}