package com.project.consultcep.ui.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.consultcep.R
import com.project.consultcep.databinding.FragmentConsultBinding
import com.project.consultcep.network.CepProperty

class ConsultFragment : Fragment() {

    private lateinit var viewModel: ConsultViewModel
    private lateinit var binding: FragmentConsultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val argumets = ConsultFragmentArgs.fromBundle(requireArguments())
        val viewModelFactory = ConsultViewModelFactory(argumets.cep)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(ConsultViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_consult, container, false)

        binding.consultViewModel = viewModel

        viewModel.mutableLiveData.observe(viewLifecycleOwner, { action ->

            when (action) {
                is ConsultAction.Success -> apiWorked(action.result)
                is ConsultAction.Fail -> apiFail(action.messageFail)
            }

        })

        return binding.root
    }

    fun apiWorked(cepProperty: CepProperty) {
        Toast.makeText(context, "FUNFOU", Toast.LENGTH_LONG).show()
        binding.textViewConsultCep.text = cepProperty.code
        binding.textViewConsultState.text = cepProperty.state
        binding.textViewConsultCity.text = cepProperty.city
        binding.textViewConsultDistrict.text = cepProperty.district
        binding.textViewConsultAddress.text = cepProperty.address
        binding.imageViewLoadingImg.visibility = View.GONE
        binding.scrowViewConsultInformation.visibility = View.VISIBLE
    }

    fun apiFail(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}