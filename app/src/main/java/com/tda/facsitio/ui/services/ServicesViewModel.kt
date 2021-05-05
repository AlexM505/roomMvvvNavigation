package com.tda.facsitio.ui.services

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tda.facsitio.data.db.FactsitioDatabase
import com.tda.facsitio.data.model.DhtItinTrabajoServicio
import com.tda.facsitio.data.repository.DhtItinTrabajoServicioRepository
import com.tda.facsitio.utils.Resource
import kotlinx.coroutines.launch
import java.lang.Exception

class ServicesViewModel(application: Application) : AndroidViewModel(application) {

    private val dhtItinTrabajoServicioDao = FactsitioDatabase.getDatabase(application).dhtItinTrabajoServicioDao()
    private val repo : DhtItinTrabajoServicioRepository

    private val serviciosByItin = MutableLiveData<Resource<List<DhtItinTrabajoServicio>>>()

    init{
        repo = DhtItinTrabajoServicioRepository(dhtItinTrabajoServicioDao)
    }

    fun searchServiciosByItin(itin : String){
        viewModelScope.launch {
            serviciosByItin.postValue(Resource.loading(null))
            try {
                val servicios = mutableListOf<DhtItinTrabajoServicio>()
                servicios.addAll(repo.getServiciosByItin(itin) as MutableList<DhtItinTrabajoServicio>)

                serviciosByItin.postValue(Resource.success(servicios))
            }catch (e: Exception){
                serviciosByItin.postValue(Resource.error(e.message?:"Falla en searchServiciosByItin", null))
            }
        }
    }

    fun getServiciosByItin() : LiveData<Resource<List<DhtItinTrabajoServicio>>>{
        return serviciosByItin
    }
}