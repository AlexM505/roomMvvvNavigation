package com.tda.facsitio.ui.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tda.facsitio.databinding.FragmentServicesBinding
import kotlinx.android.synthetic.main.activity_main.*

class ServicesFragment : Fragment() {

    private var _binding : FragmentServicesBinding?= null
    private val binding get() = _binding!!

    private val servicesFragmentArgs by navArgs<ServicesFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentServicesBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.args = servicesFragmentArgs

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().bottom_nav.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}