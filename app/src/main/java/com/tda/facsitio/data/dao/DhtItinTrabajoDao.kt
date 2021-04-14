package com.tda.facsitio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tda.facsitio.data.model.DhtItinTrabajo

@Dao
interface DhtItinTrabajoDao {

    @Query("SELECT * FROM dht_itin_trabajo ORDER BY ix_itinerario_trabajo ASC")
    fun getAllItinTrabajo(): LiveData<List<DhtItinTrabajo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItinerario(vararg itinerarioTrabajo: DhtItinTrabajo)

    @Update
    suspend fun updateItinerario(itinerarioTrabajo: DhtItinTrabajo)

    @Query("DELETE FROM dht_itin_trabajo")
    suspend fun deleteAll()

    //Insert de test
    @Query("insert into dht_itin_trabajo (ix_itinerario_trabajo, id_mes, es_itinerario_trabajo, ti_itinerario_trabajo, fe_generacion, fe_programa, fe_ejecucion, fh_apertura, fh_cierre, cc_inmuebles, cc_contratos, cc_servicios, cc_acciones_asignadas, cc_acciones_ejecutadas, cc_acciones_fallidas, cc_acciones_anomalas, cc_acciones_correctas, fh_asignacion, fh_recepcion, id_asignacion_movil, id_asignacion_usuario) " +
            "values ('202001100-02-LECT', 202101, 'MOVIL', 'LECTU', '2021-02-23 00:00:00.000000', '2021-02-25 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 3, 3, 3, 3, 0, 0, 0, 0, '2021-02-25 00:00:00.000000', '2021-02-25 00:00:00.000000', 'm001', 'u001')"
    )
    suspend fun insertValueDefault()
}