package com.tda.facsitio.ui.workItinerary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tda.facsitio.data.db.FactsitioDatabase
import com.tda.facsitio.data.model.DhtItinTrabajo
import com.tda.facsitio.data.repository.DhtItinTrabajoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkItineraryViewModel(application: Application) : AndroidViewModel(application) {

    private val dhtItinTrabajoDao = FactsitioDatabase.getDatabase(application).dhtItinTrabajoDao()
    private val repo : DhtItinTrabajoRepository

    val getAllItin: LiveData<List<DhtItinTrabajo>>

    init {
        repo = DhtItinTrabajoRepository(dhtItinTrabajoDao)
        getAllItin = repo.getAllItinTrabajo
    }

    fun insertItinerarioTrabajo(itinerario: DhtItinTrabajo){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertItinerario(itinerario)
        }
    }
}