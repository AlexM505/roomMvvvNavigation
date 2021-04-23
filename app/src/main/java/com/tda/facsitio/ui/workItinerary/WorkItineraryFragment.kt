package com.tda.facsitio.ui.workItinerary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tda.facsitio.data.db.FactsitioDatabase
import com.tda.facsitio.data.db.rePopulateDb
import com.tda.facsitio.databinding.FragmentWorkItineraryBinding
import com.tda.facsitio.ui.zhelp.SharedViewModel
import com.tda.facsitio.utils.LoadingDialog
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class WorkItineraryFragment : Fragment() {

    private var _binding: FragmentWorkItineraryBinding?= null
    private val binding get() = _binding!!

    private val mWorkItineraryViewModel: WorkItineraryViewModel by viewModels()
    private val mSharedViewModel: SharedViewModel by viewModels()
    private val workItinAdapter : WorkItineraryAdapter by lazy { WorkItineraryAdapter() }

    private val loadingDialog by lazy {
        LoadingDialog(requireContext()).apply {
            lifecycle.addObserver(this)
        }
    }

    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkItineraryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.mSharedViewModel = mSharedViewModel

        scope.launch {
            rePopulateDb(FactsitioDatabase.getDatabase(requireContext()))
        }

        setupListOfItin()
        observeListOfItin()

        return binding.root
    }

    private fun setupListOfItin(){
        val recyclerView = binding.rvWorkItineraries
        recyclerView.adapter = workItinAdapter
        recyclerView.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false)
        recyclerView.itemAnimator = SlideInUpAnimator().apply { addDuration = 300 }
    }

    private fun observeListOfItin(){
        mWorkItineraryViewModel.getAllItin.observe(viewLifecycleOwner,{ listData ->
            mSharedViewModel.checkIfDbEmpty(listData)
            workItinAdapter.setData(listData)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}