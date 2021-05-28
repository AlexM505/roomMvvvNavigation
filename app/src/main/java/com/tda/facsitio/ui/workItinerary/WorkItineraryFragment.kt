package com.tda.facsitio.ui.workItinerary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tda.facsitio.data.db.FactsitioDatabase
import com.tda.facsitio.data.db.rePopulateDb
import com.tda.facsitio.databinding.FragmentWorkItineraryBinding
import com.tda.facsitio.ui.services.ServicesFragment
import com.tda.facsitio.ui.zhelp.SharedViewModel
import com.tda.facsitio.utils.MyPreferencesUtil
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_work_itinerary.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class WorkItineraryFragment : Fragment() {

    companion object{
        const val TAG_SCREEN = "WORK_SCREEN"
    }
    private var _binding: FragmentWorkItineraryBinding?= null
    private val binding get() = _binding!!

    private val mWorkItineraryViewModel: WorkItineraryViewModel by viewModels()
    private val mSharedViewModel: SharedViewModel by viewModels()
    private val workItinAdapter : WorkItineraryAdapter by lazy { WorkItineraryAdapter() }

    private lateinit var preferences: MyPreferencesUtil
    private val scope = CoroutineScope(Job() + Dispatchers.IO)
    private var flatSwipe = true

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
        if (preferences.loadTagFragment().equals(ServicesFragment.TAG_SCREEN)){
            preferences.setTagFragment(TAG_SCREEN)
            mSharedViewModel.fadeAnim(requireActivity().bottom_nav)
        }else{
            //primera vez que se ejecuta la app , se configura el tag de la vista workItinerary
            preferences.setTagFragment(TAG_SCREEN)
        }

        setupListOfItin()
        observeListOfItin()
        swipeToDownloadItineraries()
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
        mWorkItineraryViewModel.getAllItin.observe(viewLifecycleOwner, Observer { listData ->
            mSharedViewModel.checkIfDbEmpty(listData)
            workItinAdapter.setData(listData)

            //Validamos si hay itinerarios cargados para no volver a insertarlos
            //por unique consraint (cambiar validacion cuando carguemos desde servidor)
            if(listData.isNotEmpty())
                flatSwipe = false
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun swipeToDownloadItineraries(){
        swipeItin.setOnRefreshListener {
            if (flatSwipe){
                scope.launch {
                    rePopulateDb(FactsitioDatabase.getDatabase(requireContext()))
                }
            }else{
                Toast.makeText(requireContext(),"No hay nada para cargar",Toast.LENGTH_SHORT).show()
            }

            swipeItin.isRefreshing = false
        }

    }

}