package com.tda.facsitio.data.repository

import androidx.lifecycle.LiveData
import com.tda.facsitio.data.dao.DhtItinTrabajoServicioDao
import com.tda.facsitio.data.model.DhtItinTrabajoServicio

class DhtItinTrabajoServicioRepository(private val dhtItinTrabajoServicioDao: DhtItinTrabajoServicioDao) {

    suspend fun getServiciosByItin(itinerario : String): List<DhtItinTrabajoServicio>{
        return dhtItinTrabajoServicioDao.allServiciosByItin(itinerario)
    }

    suspend fun insertItinerario(dhtItinTrabajoServicio: DhtItinTrabajoServicio){
        dhtItinTrabajoServicioDao.insertServicio(dhtItinTrabajoServicio)
    }

    fun searchServiciosDb(searchQuery: String): LiveData<List<DhtItinTrabajoServicio>>{
        return dhtItinTrabajoServicioDao.searchServiciosDb(searchQuery)
    }
}