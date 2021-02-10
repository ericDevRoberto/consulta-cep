package com.project.consultcep.ui.historyFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Database
import com.project.consultcep.R
import com.project.consultcep.databinding.FragmentHistoryBinding
import com.project.consultcep.databinding.FragmentHomeBinding
import com.project.consultcep.db.DataBase
import com.project.consultcep.ui.consultFragment.ConsultFragmentDirections
import com.project.consultcep.ui.historyFragment.adapter.HistoryAdapter

class HistoryFragment : Fragment() {

    private lateinit var viewModel: HistoryViewModel

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(this.activity).application

        val dataSource = DataBase.getInstance(application).cepHistoryDao

        val viewModelFactory = HistoryViewModelFactory(dataSource)

        viewModel = ViewModelProvider(this, viewModelFactory).get(HistoryViewModel::class.java)

        viewModel.mutableLiveData.observe(viewLifecycleOwner,{ action ->

            when(action){
                is HistoryAction.toBack ->backToHome()
            }

        })

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        binding.historyViewModel = viewModel
        binding.lifecycleOwner = this

        //RecycleView

        val adapter = HistoryAdapter()
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