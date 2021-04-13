package com.tda.facsitio.data.db

import com.tda.facsitio.data.dao.DhtItinTrabajoDao
import com.tda.facsitio.data.model.DhtItinTrabajo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//Funcion para ingresar datos de pruebas
suspend fun rePopulateDb(database: FactsitioDatabase?){

    database?.let { db ->
        withContext(Dispatchers.IO){
            val dhtItinTrabajoDao : DhtItinTrabajoDao = db.dhtItinTrabajoDao()

            dhtItinTrabajoDao.deleteAll()

            val itinerary = DhtItinTrabajo(
                ixItinerarioTrabajo = "212301999903", idMes = 4,
                esItinerarioTrabajo = "estado", tiItinerarioTrabajo = "",
                feGeneracion = "09/04/2021", fePrograma = "12/04/2021",feEjecucion = "",fhApertura = "12/04/2021 14:52",fhCierre = "",
                ccInmuebles = 1,ccContratos = 50,ccServicios = 50,ccAccionesAsignadas = 50, ccAccionesEjecutadas = 0,
                ccAccionesFallidas = 0, ccAccionesAnomalas = 0,ccAccionesCorrectas = 0,
                fhAsignacion = "12/04/2021", fhRecepcion = "12/04/2021",idAsignacionMovil = "99",idAsignacionUsuario = "AlexD"
            )

            dhtItinTrabajoDao.insertItinerario(itinerary)
        }
    }

}