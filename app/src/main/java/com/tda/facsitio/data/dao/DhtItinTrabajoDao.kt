package com.tda.facsitio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tda.facsitio.data.model.DhtItinTrabajo

@Dao
interface DhtItinTrabajoDao {

    @Query("SELECT * FROM dht_itin_trabajo ORDER BY ix_itinerario_trabajo ASC")
    fun getAllItinTrabajo(): LiveData<List<DhtItinTrabajo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItinerario(itinerarioTrabajo: DhtItinTrabajo)

    @Update
    suspend fun updateItinerario(itinerarioTrabajo: DhtItinTrabajo)
}