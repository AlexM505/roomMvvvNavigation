package com.tda.facsitio.data.dao

import androidx.room.*
import com.tda.facsitio.data.model.DhtItinTrabajoServicioAccion

@Dao
interface DhtItinTrabajoServicioAccionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertServicioAccion(vararg itinerarioTrabajo: DhtItinTrabajoServicioAccion)

    @Update
    suspend fun updateServicioAccion(itinerarioTrabajo: DhtItinTrabajoServicioAccion)

    @Query("DELETE FROM dht_itin_trabajo_servicio_accion")
    suspend fun deleteAll()

    @Query("SELECT * FROM dht_itin_trabajo_servicio_accion " +
            "WHERE ix_itinerario_trabajo = :ixItinTrabajo " +
            "and  id_servicio = :servicio")
    suspend fun obtenerAccionesByServicio(ixItinTrabajo: String, servicio: Long): List<DhtItinTrabajoServicioAccion>


    // ----- Datos de prueba
    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 2, 1, 105, 105, '1', 'LECTU', 'PENDI', 'Tomar lectura del servicio', 0, 0, 0, 0)")
    suspend fun insertAccionDefaultUno()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 2, 2, 105, 105, '2', 'IMPFA', 'PENDI', 'Impresion de factura del servicio', 0, 0, 0, 0)")
    suspend fun insertAccionDefaultDos()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 3, 3, 106, 106, '3', 'LECTU', 'PENDI', 'Tomar lectura del servicio', 0, 0, 0, 0)")
    suspend fun insertAccionDefaultTres()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 3, 4, 106, 106, '4', 'CARTA', 'PENDI', 'Entregar carta de notificacion del servicio', 0, 0, 0, 0);")
    suspend fun insertAccionDefaultCuatro()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 3, 5, 106, 106, '5', 'COBRO', 'PENDI', 'Realizar cobro del servicio', 0, 0, 0, 0);")
    suspend fun insertAccionDefaultCinco()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 4, 6, 107, 107, '7', 'LECTU', 'PENDI', 'Tomar lectura del servicio', 0, 0, 0, 0)")
    suspend fun insertAccionDefaultSiete()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 5, 7, 108, 108, '8', 'LECTU', 'PENDI', 'Tomar lectura del servicio', 0, 0, 0, 0)")
    suspend fun insertAccionDefaultOcho()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 6, 8, 109, 109, '9', 'LECTU', 'PENDI', 'Tomar lectura del servicio', 0, 0, 0, 0)")
    suspend fun insertAccionDefaultNueve()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 7, 9, 110, 110, '10', 'LECTU', 'PENDI', 'Tomar lectura del servicio', 0, 0, 0, 0)")
    suspend fun insertAccionDefaultDiez()

    @Query("INSERT INTO dht_itin_trabajo_servicio_accion (ix_itinerario_trabajo, se_itinerario_trabajo, se_trabajo_accion, id_servicio, id_contrato, id_trabajo_accion, ti_trabajo_accion, es_trabajo_accion, referencia_accion, fl_accion_ejecutada, fl_accion_fallida, fl_accion_anomala, fl_accion_correcta) " +
            "VALUES ('202001100-02-LECT', 8, 10, 111, 111, '11', 'LECTU', 'PENDI', 'Tomar lectura del servicio', 0, 0, 0, 0)")
    suspend fun insertAccionDefaultOnce()
}