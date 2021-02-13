package com.project.consultcep.presentation.historyFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
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

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)

        viewModel.mutableLiveData.observe(viewLifecycleOwner, { action ->

            when (action) {
                is HistoryAction.ToBack -> backToHome()
                is HistoryAction.Success -> goToSelected()
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {

            backToHome()
        }

        with(binding) {

            historyViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner

            //RecycleView

            val adapter = HistoryAdapter(HistoryRecycleViewClickListener { cepHistory ->

                viewModel.getCepToSelected(cepHistory)
            })

            recycleViewHistory.adapter = adapter

            val manager = GridLayoutManager(activity, 1, GridLayoutManager.VERTICAL, false)
            recycleViewHistory.layoutManager = manager

            viewModel.allHistoryCep.observe(viewLifecycleOwner, {
                adapter.submitList(it)
            })

            historyToolbar.setNavigationOnClickListener {

                backToHome()
            }

            return root
        }
    }

    private fun goToSelected() {

        findNavController().navigate(HistoryFragmentDirections.actionNavigationHistoryToNavigationSelectedCep())
    }

    private fun backToHome() {

        NavHostFragment.findNavController(this)
            .navigate(HistoryFragmentDirections.actionNavigationHistoryToNavigationHome())
    }
}