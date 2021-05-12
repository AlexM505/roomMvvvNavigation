package com.tda.facsitio.ui.serviceDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tda.facsitio.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding : FragmentDetailBinding?= null
    private val binding get() = _binding!!
    private val detailFragmentArgs by navArgs<DetailFragmentArgs>()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container, false)
        binding.lifecycleOwner = this
        binding.args = detailFragmentArgs


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}