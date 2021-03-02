package com.tda.facsitio.ui.workItinerary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tda.facsitio.data.db.FactsitioDatabase
import com.tda.facsitio.data.model.DhtItinerariosTrabajo
import com.tda.facsitio.data.repository.DhtItinerariosTrabajoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkItineraryViewModel(application: Application) : AndroidViewModel(application) {

    private val dhtItinerariosTrabajoDao = FactsitioDatabase.getDatabase(application).dhtItinerariosTrabajoDao()
    private val repo : DhtItinerariosTrabajoRepository

    val getAllItinerarios: LiveData<List<DhtItinerariosTrabajo>>

    init {
        repo = DhtItinerariosTrabajoRepository(dhtItinerariosTrabajoDao)
        getAllItinerarios = repo.getAllItinerariosTrabajo
    }

    fun insertItinerarioTrabajo(itinerario: DhtItinerariosTrabajo){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertItinerario(itinerario)
        }
    }
}