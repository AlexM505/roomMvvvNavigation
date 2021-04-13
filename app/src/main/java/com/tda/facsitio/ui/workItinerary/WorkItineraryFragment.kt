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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class WorkItineraryFragment : Fragment() {

    //private val mWorkItineraryViewModel: WorkItineraryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_work_itinerary, container, false)

        lifecycleScope.launch(Dispatchers.IO) {
            rePopulateDb(FactsitioDatabase.getDatabase(requireContext()))
        }

        return view
    }

}