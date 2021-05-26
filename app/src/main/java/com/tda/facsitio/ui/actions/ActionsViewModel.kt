package com.tda.facsitio.ui.actions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tda.facsitio.data.db.FactsitioDatabase
import com.tda.facsitio.data.model.DhtItinTrabajoServicioAccion
import com.tda.facsitio.data.repository.DhtItinTrabajoServicioAccionRepository
import com.tda.facsitio.utils.Resource
import kotlinx.coroutines.launch
import java.lang.Exception

class ActionsViewModel(application: Application) : AndroidViewModel(application) {

    private val dhtItinTrabajoServicioAccionDao = FactsitioDatabase.getDatabase(application).dhtItinTrabajoServicioAccionDao()
    private val repoAccion : DhtItinTrabajoServicioAccionRepository

    private val _accionesServicio = MutableLiveData<Resource<List<DhtItinTrabajoServicioAccion>>>()

    init{
        repoAccion = DhtItinTrabajoServicioAccionRepository(dhtItinTrabajoServicioAccionDao)
    }

    val accionesServicio: LiveData<Resource<List<DhtItinTrabajoServicioAccion>>> = _accionesServicio

    fun obtenerAccionesByServicio(ixItin : String, servicio: Long){
        viewModelScope.launch {
            _accionesServicio.postValue(Resource.loading(null))
            try {
                val acciones = mutableListOf<DhtItinTrabajoServicioAccion>()
                acciones.addAll(repoAccion.obtenerAccionesByServicio(ixItin, servicio) as MutableList<DhtItinTrabajoServicioAccion>)

                _accionesServicio.postValue(Resource.success(acciones))
            }catch (e: Exception){
                _accionesServicio.postValue(Resource.error(e.message?:"Falla en searchServiciosByItin", null))
            }
        }
    }
}