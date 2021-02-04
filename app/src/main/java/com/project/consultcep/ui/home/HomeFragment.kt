package com.project.consultcep.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.project.consultcep.R
import com.project.consultcep.databinding.FragmentHomeBinding
import com.project.consultcep.utils.InputMask
import com.project.consultcep.utils.MASK_CEP

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.mutableLiveData.observe(viewLifecycleOwner, { action ->
            when (action) {
                is HomeAction.Success -> success(action.cep)
                is HomeAction.Fail -> fail()
            }
        })

        with(binding) {
            homeViewModel = viewModel
            lifecycleOwner = lifecycleOwner

            homeEditTextCep.addTextChangedListener(
                InputMask.mask(
                    MASK_CEP,
                    homeEditTextCep
                ) { viewModel.putCep(homeEditTextCep.text.toString()) }
            )
            return root
        }
    }

    private fun fail() {

        view?.let { Snackbar.make(it, R.string.snakbar_invalid_cep, Snackbar.LENGTH_SHORT).show() }
    }

    private fun success(cep: String) {

        this.findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToNavigationConsult(cep = cep))
    }
}