package com.tda.facsitio.ui.workItinerary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tda.facsitio.R
import com.tda.facsitio.data.db.FactsitioDatabase
import com.tda.facsitio.data.db.rePopulateDb
import com.tda.facsitio.data.model.DhtItinTrabajo
import com.tda.facsitio.databinding.FragmentWorkItineraryBinding
import com.tda.facsitio.ui.SharedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class WorkItineraryFragment : Fragment() {

    private var _binding: FragmentWorkItineraryBinding?= null
    private val binding get() = _binding!!

    private val mWorkItineraryViewModel: WorkItineraryViewModel by viewModels()
    private val mSharedViewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWorkItineraryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.mSharedViewModel = mSharedViewModel

        lifecycleScope.launch(Dispatchers.IO) {
            rePopulateDb(FactsitioDatabase.getDatabase(requireContext()))
        }

        val list = listOf<DhtItinTrabajo>()
        mSharedViewModel.checkIfDbEmpty(list)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}