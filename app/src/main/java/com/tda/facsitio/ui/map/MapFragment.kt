package com.tda.facsitio.ui.map

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.geojson.Feature
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.PropertyFactory.*
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import com.mapbox.mapboxsdk.utils.BitmapUtils
import com.tda.facsitio.R
import com.tda.facsitio.databinding.FragmentMapBinding
import com.tda.facsitio.ui.workItinerary.WorkItineraryFragment
import com.tda.facsitio.ui.zhelp.SharedViewModel
import com.tda.facsitio.utils.ConstUtils.Companion.ICON_ID
import com.tda.facsitio.utils.ConstUtils.Companion.LAYER_ID
import com.tda.facsitio.utils.ConstUtils.Companion.SOURCE_ID
import com.tda.facsitio.utils.MyPreferencesUtil
import kotlinx.android.synthetic.main.activity_main.*


class MapFragment : Fragment(), OnMapReadyCallback ,PermissionsListener  {

    companion object{
        const val TAG_SCREEN = "MAP_SCREEN"
    }
    private var _binding : FragmentMapBinding?= null
    private val binding get() = _binding!!
    private val mapFragmentArgs by navArgs<MapFragmentArgs>()

    private var permissionsManager : PermissionsManager? = null
    private lateinit var mapboxMap : MapboxMap
    private var mapView : MapView? = null
    private lateinit var styleMap: String

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
        styleMap = if(preferences.loadDarkModeState())
            Style.DARK
        else
            Style.MAPBOX_STREETS

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

    override fun onMapReady(map: MapboxMap) {
        mapboxMap = map
        initAddMarker(mapboxMap)
    }

    private fun initAddMarker(map: MapboxMap) {
        val symbolLayers = ArrayList<Feature>()
        symbolLayers.add(Feature.fromGeometry(Point.fromLngLat(-86.262795,12.102613)))
        symbolLayers.add(Feature.fromGeometry(Point.fromLngLat(-86.262051,12.102702)))
        symbolLayers.add(Feature.fromGeometry(Point.fromLngLat(-86.261855,12.103417)))
        map.setStyle(
            Style.Builder().fromUri(styleMap)
                .withImage(ICON_ID, BitmapUtils.getBitmapFromDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.mapbox_marker_icon_default))!!)
                .withSource(GeoJsonSource(SOURCE_ID, FeatureCollection.fromFeatures(symbolLayers)))
                .withLayer(SymbolLayer(LAYER_ID, SOURCE_ID)
                    .withProperties(iconImage(ICON_ID),
                        iconSize(1.0f),
                        iconAllowOverlap(true),
                        iconIgnorePlacement(true)
                    )
                )
        )
        {
            //mostrando ubicacion del dispositivo
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

            val locationComponent = mapboxMap.locationComponent
            locationComponent.activateLocationComponent(
                LocationComponentActivationOptions.builder(requireContext(), loadedMapStyle)
                    .locationComponentOptions(customLocationComponentOptions)
                    .build()
            )

            locationComponent.isLocationComponentEnabled = true
            locationComponent.cameraMode = CameraMode.TRACKING_COMPASS
            locationComponent.renderMode = RenderMode.COMPASS

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
            mapboxMap.getStyle {
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