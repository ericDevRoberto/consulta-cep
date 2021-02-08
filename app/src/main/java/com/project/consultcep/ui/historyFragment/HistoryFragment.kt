package com.project.consultcep.ui.historyFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.consultcep.R
import com.project.consultcep.databinding.FragmentHistoryBinding
import com.project.consultcep.databinding.FragmentHomeBinding

class HistoryFragment : Fragment() {

    private lateinit var viewModel: HistoryViewModel

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container,false)

        viewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)

        return binding.root
    }
}