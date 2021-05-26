package com.tda.facsitio.data.repository

import com.tda.facsitio.data.dao.DhtItinTrabajoServicioAccionDao
import com.tda.facsitio.data.model.DhtItinTrabajoServicioAccion

class DhtItinTrabajoServicioAccionRepository(private val dhtItinTrabajoServicioAccionDao: DhtItinTrabajoServicioAccionDao) {

    suspend fun obtenerAccionesByServicio(ixItinTrabajo: String, servicio: Long) : List<DhtItinTrabajoServicioAccion>{
        return dhtItinTrabajoServicioAccionDao.obtenerAccionesByServicio(ixItinTrabajo, servicio)
    }
}