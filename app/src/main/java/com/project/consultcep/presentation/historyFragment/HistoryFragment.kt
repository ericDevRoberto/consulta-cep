package com.project.consultcep.presentation.historyFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.project.consultcep.R
import com.project.consultcep.databinding.FragmentHistoryBinding
import com.project.consultcep.presentation.historyFragment.adapter.HistoryAdapter
import com.project.consultcep.presentation.historyFragment.adapter.HistoryRecycleViewClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment() {

    private val viewModel: HistoryViewModel by viewModel()

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        viewModel.mutableLiveData.observe(viewLifecycleOwner,{ action ->

            when(action){
                is HistoryAction.toBack ->backToHome()
            }

        })

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        binding.historyViewModel = viewModel
        binding.lifecycleOwner = this

        //RecycleView

        val adapter = HistoryAdapter(HistoryRecycleViewClickListener { cepHistoryId ->
            Toast.makeText(context, "$cepHistoryId", Toast.LENGTH_LONG).show()
        })
        binding.recycleViewHistory.adapter = adapter

        val manager = GridLayoutManager(activity, 1, GridLayoutManager.VERTICAL,false)
        binding.recycleViewHistory.layoutManager = manager

        viewModel.allHistoryCep.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })


        return binding.root
    }

    private fun backToHome() {
        NavHostFragment.findNavController(this)
            .navigate(HistoryFragmentDirections.actionNavigationHistoryToNavigationHome())
    }
}