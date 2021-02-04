package com.project.consultcep.ui.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.consultcep.R

class ConsultFragment : Fragment() {

    private lateinit var consultViewModel: ConsultViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        consultViewModel =
                ViewModelProvider(this).get(ConsultViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_consult, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        consultViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}