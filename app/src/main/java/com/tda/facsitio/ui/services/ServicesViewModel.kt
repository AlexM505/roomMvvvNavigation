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

    private val _serviciosByItin = MutableLiveData<Resource<List<DhtItinTrabajoServicio>>>()

    init{
        repo = DhtItinTrabajoServicioRepository(dhtItinTrabajoServicioDao)
    }

    fun searchServiciosByItin(itin : String){
        viewModelScope.launch {
            _serviciosByItin.postValue(Resource.loading(null))
            try {
                val servicios = mutableListOf<DhtItinTrabajoServicio>()
                servicios.addAll(repo.getServiciosByItin(itin) as MutableList<DhtItinTrabajoServicio>)

                _serviciosByItin.postValue(Resource.success(servicios))
            }catch (e: Exception){
                _serviciosByItin.postValue(Resource.error(e.message?:"Falla en searchServiciosByItin", null))
            }
        }
    }

    val serviciosByItin: LiveData<Resource<List<DhtItinTrabajoServicio>>> = _serviciosByItin

    fun searchServiciosDb(searchQuery:String): LiveData<List<DhtItinTrabajoServicio>>{
        return repo.searchServiciosDb(searchQuery)
    }
}