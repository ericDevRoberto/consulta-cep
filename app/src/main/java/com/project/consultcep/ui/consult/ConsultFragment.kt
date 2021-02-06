package com.project.consultcep.ui.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.project.consultcep.R
import com.project.consultcep.databinding.FragmentConsultBinding
import com.project.consultcep.data.CepProperty
import com.project.consultcep.utils.alertDialog

class ConsultFragment : Fragment() {

    private lateinit var viewModel: ConsultViewModel
    private lateinit var binding: FragmentConsultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val arguments = ConsultFragmentArgs.fromBundle(requireArguments())
        val viewModelFactory = ConsultViewModelFactory(arguments.cep)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(ConsultViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_consult, container, false)

        viewModel.mutableLiveData.observe(viewLifecycleOwner, { action ->

            when (action) {
                is ConsultAction.ApiSuccess -> apiWorked(action.result)
                is ConsultAction.Loading -> loading()
                is ConsultAction.ApiInternetError -> apiFail(R.string.dialog_message_fail_internet)
                is ConsultAction.ApiNotFound -> apiFail(R.string.dialog_message_not_found)
                is ConsultAction.ApiBadRequest -> apiFail(R.string.dialog_message_bad_request)
                is ConsultAction.ApiServerError -> apiFail(R.string.dialog_message_fail_server)
                is ConsultAction.ApiFail -> apiFail(R.string.dialog_message_fail_api)
                is ConsultAction.BackToHome -> backToHome()
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            backToHome()
        }

        with(binding){

            consultViewModel = viewModel

            consultToolbar.setNavigationOnClickListener {
                backToHome()
            }
            return root
        }
    }

    private fun loading(){
        binding.imageViewLoadingImg.visibility = View.VISIBLE
    }

    private fun apiWorked(cepProperty: CepProperty) {
        with(binding) {
            textViewConsultCep.text = cepProperty.code
            textViewConsultState.text = cepProperty.state
            textViewConsultCity.text = cepProperty.city
            textViewConsultDistrict.text = cepProperty.district
            textViewConsultAddress.text = cepProperty.address
            imageViewLoadingImg.visibility = View.GONE
            scrollViewConsultInformation.visibility = View.VISIBLE
        }
    }

    private fun apiFail(@StringRes alertMessage: Int) {
        alertDialog(
            message = alertMessage,
            onClickBntNegative = { backToHome() })
    }

    private fun backToHome() {
        NavHostFragment.findNavController(this)
            .navigate(ConsultFragmentDirections.actionNavigationConsultToNavigationHome())
    }
}