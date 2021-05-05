package com.tda.facsitio.ui.workItinerary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tda.facsitio.databinding.FragmentWorkItineraryBinding
import com.tda.facsitio.ui.services.ServicesFragment
import com.tda.facsitio.ui.zhelp.SharedViewModel
import com.tda.facsitio.utils.MyPreferencesUtil
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


class WorkItineraryFragment : Fragment() {

    private var _binding: FragmentWorkItineraryBinding?= null
    private val binding get() = _binding!!

    private val mWorkItineraryViewModel: WorkItineraryViewModel by viewModels()
    private val mSharedViewModel: SharedViewModel by viewModels()
    private val workItinAdapter : WorkItineraryAdapter by lazy { WorkItineraryAdapter() }

    private lateinit var preferences: MyPreferencesUtil
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkItineraryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.mSharedViewModel = mSharedViewModel

        preferences = MyPreferencesUtil(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (preferences.loadTagFragment().equals(ServicesFragment.TAG_SCREEN))
            mSharedViewModel.fadeAnim(requireActivity().bottom_nav)
//        scope.launch {
//            rePopulateDb(FactsitioDatabase.getDatabase(requireContext()))
//        }

        setupListOfItin()
        observeListOfItin()
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
        System.out.println("Pasamos por onDestroyView")
    }

    override fun onPause() {
        super.onPause()
        System.out.println("Pasamos por onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        System.out.println("Pasamos por onDestroy")
    }

}