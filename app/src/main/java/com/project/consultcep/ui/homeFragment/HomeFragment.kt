package com.project.consultcep.ui.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.project.consultcep.R
import com.project.consultcep.databinding.FragmentHomeBinding
import com.project.consultcep.utils.InputMask
import com.project.consultcep.utils.MASK_CEP
import com.project.consultcep.utils.alertDialog
import com.project.consultcep.utils.hideKeyboard

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.mutableLiveData.observe(viewLifecycleOwner, { action ->
            when (action) {
                is HomeAction.Success -> success(action.cep)
                is HomeAction.Fail -> fail()
                is HomeAction.ToHistory -> toHistory()
            }
        })

        with(binding) {
            homeViewModel = viewModel
            lifecycleOwner = lifecycleOwner

            homeEditTextCep.addTextChangedListener(
                InputMask.mask(
                    MASK_CEP,
                    homeEditTextCep
                ) { putCepViewModel() }
            )
            return root
        }
    }

    private fun putCepViewModel() {

        viewModel.putCep(binding.homeEditTextCep.text.toString())
        hideKeyboard()
    }

    private fun fail() {

        alertDialog(
            message = R.string.dialog_erro_cep
        )
    }

    private fun success(cep: String) {

        this.findNavController()
            .navigate(HomeFragmentDirections.actionNavigationHomeToNavigationConsult(cep = cep))
    }

    private fun toHistory() {

        this.findNavController()
            .navigate(HomeFragmentDirections.actionNavigationHomeToNavigationHistory())
    }
}