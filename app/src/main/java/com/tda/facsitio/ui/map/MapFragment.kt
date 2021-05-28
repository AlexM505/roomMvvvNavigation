package com.tda.facsitio.ui.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.tda.facsitio.R
import com.tda.facsitio.databinding.FragmentMapBinding
import com.tda.facsitio.ui.workItinerary.WorkItineraryFragment
import com.tda.facsitio.ui.zhelp.SharedViewModel
import com.tda.facsitio.utils.MyPreferencesUtil
import kotlinx.android.synthetic.main.activity_main.*


class MapFragment : Fragment() {

    companion object{
        const val TAG_SCREEN = "MAP_SCREEN"
    }
    private var _binding : FragmentMapBinding?= null
    private val binding get() = _binding!!

    private var mapView : MapView? = null
    private lateinit var preferences: MyPreferencesUtil
    private val mSharedViewModel : SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(requireContext(), getString(R.string.access_token))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this

        preferences = MyPreferencesUtil(requireContext())
        mapView = binding.mapView
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync { mapboxMap ->

            mapboxMap.setStyle(Style.MAPBOX_STREETS) {

            }

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(preferences.loadTagFragment().equals(WorkItineraryFragment.TAG_SCREEN)){
            preferences.setTagFragment(TAG_SCREEN)
            mSharedViewModel.fadeOutAnim(requireActivity().bottom_nav)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mapView?.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }
}