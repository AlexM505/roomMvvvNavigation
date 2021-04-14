package com.tda.facsitio.data.repository

import androidx.lifecycle.LiveData
import com.tda.facsitio.data.dao.DhtItinTrabajoServicioDao
import com.tda.facsitio.data.model.DhtItinTrabajoServicio

class DhtItinTrabajoServicioRepository(private val dhtItinTrabajoServicioDao: DhtItinTrabajoServicioDao) {

    fun getServiciosByItin(itinerario : String): LiveData<List<DhtItinTrabajoServicio>>{
        return dhtItinTrabajoServicioDao.getAllServiciosByItin(itinerario)
    }

    suspend fun insertItinerario(dhtItinTrabajoServicio: DhtItinTrabajoServicio){
        dhtItinTrabajoServicioDao.insertServicio(dhtItinTrabajoServicio)
    }
}