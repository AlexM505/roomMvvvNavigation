package com.tda.facsitio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tda.facsitio.data.model.DhtItinerariosTrabajo

@Dao
interface DhtItinerariosTrabajoDao {

    @Query("SELECT * FROM dht_itinerarios_trabajo ORDER BY ixItinerarioTrabajo ASC")
    fun getAllItinerariosTrabajo(): LiveData<List<DhtItinerariosTrabajo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItinerario(itinerarioTrabajo: DhtItinerariosTrabajo)

    @Update
    suspend fun updateItinerario(itinerarioTrabajo: DhtItinerariosTrabajo)
}