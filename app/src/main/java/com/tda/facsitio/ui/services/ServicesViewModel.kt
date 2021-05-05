package com.tda.facsitio.ui.services

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.tda.facsitio.data.db.FactsitioDatabase
import com.tda.facsitio.data.model.DhtItinTrabajoServicio
import com.tda.facsitio.data.repository.DhtItinTrabajoServicioRepository

class ServicesViewModel(application: Application) : AndroidViewModel(application) {

    private val dhtItinTrabajoServicioDao = FactsitioDatabase.getDatabase(application).dhtItinTrabajoServicioDao()
    private val repo : DhtItinTrabajoServicioRepository

    init{
        repo = DhtItinTrabajoServicioRepository(dhtItinTrabajoServicioDao)
    }

    suspend fun getServiciosByItin(itin : String) : List<DhtItinTrabajoServicio>{
        return repo.getServiciosByItin(itin)
    }
}