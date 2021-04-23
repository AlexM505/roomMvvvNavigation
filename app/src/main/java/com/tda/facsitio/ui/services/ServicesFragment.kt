package com.tda.facsitio.ui.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tda.facsitio.R
import com.tda.facsitio.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {

    private var _binding : FragmentServicesBinding?= null
    private val binding get() = _binding!!

    private val servicesFragmentArgs by navArgs<ServicesFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentServicesBinding.inflate(inflater,container,false)
        binding.args = servicesFragmentArgs

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}