package com.tda.facsitio.data.db

import com.tda.facsitio.data.dao.DhtItinTrabajoDao
import com.tda.facsitio.data.dao.DhtItinTrabajoServicioDao
import com.tda.facsitio.data.model.DhtItinTrabajo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//Funcion para ingresar datos de pruebas
suspend fun rePopulateDb(database: FactsitioDatabase?){

    database?.let { db ->
        withContext(Dispatchers.IO){
            val dhtItinTrabajoDao : DhtItinTrabajoDao = db.dhtItinTrabajoDao()
            val dhtItinTrabajoServicioDao :DhtItinTrabajoServicioDao = db.dhtItinTrabajoServicioDao()

            dhtItinTrabajoDao.deleteAll()
            dhtItinTrabajoServicioDao.deleteAll()

            dhtItinTrabajoDao.insertValueDefault()
            dhtItinTrabajoServicioDao.insertServicioDefaultUno()
            dhtItinTrabajoServicioDao.insertServicioDefaultDos()
        }
    }

}