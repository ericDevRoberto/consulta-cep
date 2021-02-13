package com.project.consultcep.presentation.selectedCepFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.consultcep.R
import com.project.consultcep.databinding.FragmentSelectedCepBinding
import com.project.consultcep.domain.model.CepHistoryTable
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectedCepFragment : Fragment() {

    private val viewModel: SelectedCepViewModel by viewModel()

    private lateinit var binding: FragmentSelectedCepBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_selected_cep, container, false)

        viewModel.mutableLiveData.observe(viewLifecycleOwner, { action ->

            when (action) {
                is SelectedCepAction.Success -> putData(action.cepTable)
                is SelectedCepAction.ToBack -> backToHistory()
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){

            backToHistory()
        }

        with(binding){

            selectedViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner

            selectedCepToolbar.setNavigationOnClickListener {

                backToHistory()
            }

            return root
        }

    }

    private fun putData(data: CepHistoryTable) {

        with(binding) {

            selectedCep.text = data.cepCode
            selectedState.text = data.cepState
            selectedCity.text = data.cepCity
            selectedDistrict.text = data.cepDistrict
            selectedAddress.text = data.cepAddress
        }
    }

    private fun backToHistory(){

        findNavController().navigate(SelectedCepFragmentDirections.actionNavigationSelectedToNavigationHistory())
    }
}