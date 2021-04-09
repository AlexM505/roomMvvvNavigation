package com.tda.facsitio.ui.workItinerary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tda.facsitio.R
import com.tda.facsitio.data.model.DhtItinTrabajo


class WorkItineraryFragment : Fragment() {

    private val mWorkItineraryViewModel: WorkItineraryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_work_itinerary, container, false)

        //testing insert data
        val itinerary = DhtItinTrabajo(
            "212301999903", 3,"estado","","",
            "","","","",1,50,100,2,
            1,0,0,0,",",
            "","",""
        )

        mWorkItineraryViewModel.insertItinerarioTrabajo(itinerary)

        return view
    }

}