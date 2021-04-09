package com.tda.facsitio.data.repository

import androidx.lifecycle.LiveData
import com.tda.facsitio.data.dao.DhtItinTrabajoDao
import com.tda.facsitio.data.model.DhtItinTrabajo

class DhtItinTrabajoRepository(private val dhtItinTrabajoDao: DhtItinTrabajoDao) {

    val getAllItinTrabajo: LiveData<List<DhtItinTrabajo>> = dhtItinTrabajoDao.getAllItinTrabajo()

    suspend fun insertItinerario(dhtItinTrabajo: DhtItinTrabajo){
        dhtItinTrabajoDao.insertItinerario(dhtItinTrabajo)
    }
}