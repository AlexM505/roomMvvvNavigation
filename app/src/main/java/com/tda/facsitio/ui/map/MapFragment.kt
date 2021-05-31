package com.tda.facsitio.ui.map

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.tda.facsitio.R
import com.tda.facsitio.databinding.FragmentMapBinding
import com.tda.facsitio.ui.workItinerary.WorkItineraryFragment
import com.tda.facsitio.ui.zhelp.SharedViewModel
import com.tda.facsitio.utils.MyPreferencesUtil
import kotlinx.android.synthetic.main.activity_main.*


class MapFragment : Fragment(), OnMapReadyCallback ,PermissionsListener  {

    companion object{
        const val TAG_SCREEN = "MAP_SCREEN"
    }
    private var _binding : FragmentMapBinding?= null
    private val binding get() = _binding!!

    private var permissionsManager : PermissionsManager? = null
    private var mapboxMap : MapboxMap? = null
    private var mapView : MapView? = null
    private lateinit var preferences: MyPreferencesUtil
    private val mSharedViewModel : SharedViewModel by viewModels()

    private lateinit var styleMap: String

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
        if(preferences.loadDarkModeState())
            styleMap = Style.DARK
        else
            styleMap = Style.MAPBOX_STREETS

        mapView = binding.mapView
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(preferences.loadTagFragment().equals(WorkItineraryFragment.TAG_SCREEN)){
            preferences.setTagFragment(TAG_SCREEN)
            mSharedViewModel.fadeOutAnim(requireActivity().bottom_nav)
        }
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        this.mapboxMap = mapboxMap
        mapboxMap.setStyle(styleMap) {
            enableLocationComponent(it)
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

    @SuppressLint("MissingPermission")
    private fun enableLocationComponent(loadedMapStyle : Style){
        if (PermissionsManager.areLocationPermissionsGranted(requireContext())){

            val customLocationComponentOptions = LocationComponentOptions.builder(requireContext()).build()

            val locationComponent = mapboxMap?.locationComponent
            locationComponent?.activateLocationComponent(
                LocationComponentActivationOptions.builder(requireContext(), loadedMapStyle)
                    .locationComponentOptions(customLocationComponentOptions)
                    .build()
            )

            locationComponent?.isLocationComponentEnabled = true
            locationComponent?.cameraMode = CameraMode.TRACKING_COMPASS
            locationComponent?.renderMode = RenderMode.COMPASS

        }else{
            permissionsManager = PermissionsManager(this)
            permissionsManager!!.requestLocationPermissions(requireActivity())
        }
    }

    override fun onExplanationNeeded(permissionsToExplain: MutableList<String>?) {
        Toast.makeText(requireContext(), "Es necesario aceptar los permisos para mostrar la ubicacion del dispositivo", Toast.LENGTH_LONG).show()
    }

    override fun onPermissionResult(granted: Boolean) {
        if(granted){
            mapboxMap?.getStyle {
                enableLocationComponent(it)
            }
        }else{
            Toast.makeText(requireContext(), "User location not granted", Toast.LENGTH_LONG).show()
            //requireActivity().onBackPressed()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        permissionsManager?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}