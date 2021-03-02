package com.tda.facsitio.data.repository

import androidx.lifecycle.LiveData
import com.tda.facsitio.data.dao.DhtItinerariosTrabajoDao
import com.tda.facsitio.data.model.DhtItinerariosTrabajo

class DhtItinerariosTrabajoRepository(private val dhtItinerariosTrabajoDao: DhtItinerariosTrabajoDao) {

    val getAllItinerariosTrabajo: LiveData<List<DhtItinerariosTrabajo>> = dhtItinerariosTrabajoDao.getAllItinerariosTrabajo()

    suspend fun insertItinerario(dhtItinerariosTrabajo: DhtItinerariosTrabajo){
        dhtItinerariosTrabajoDao.insertItinerario(dhtItinerariosTrabajo)
    }
}