package com.tda.facsitio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tda.facsitio.data.model.DhtItinTrabajoServicio

@Dao
interface DhtItinTrabajoServicioDao {

    @Query("SELECT * FROM dht_itin_trabajo_servicio WHERE ix_itinerario_trabajo = :itinerario ORDER BY id_servicio ASC")
    fun getAllServiciosByItin(itinerario : String): LiveData<List<DhtItinTrabajoServicio>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertServicio(vararg itinerarioTrabajo: DhtItinTrabajoServicio)

    @Update
    suspend fun updateServicio(itinerarioTrabajo: DhtItinTrabajoServicio)

    @Query("DELETE FROM dht_itin_trabajo_servicio")
    suspend fun deleteAll()

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 2, 105, 105, 'MARIA GONZALEZ PEREZ', 'Calle Libertador 333, Barrio Centro, Managua', 'Por puerta principal', 'M002 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', 'Coordenadas XXX')")
    suspend fun insertServicioDefaultUno()

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 3, 106, 106, 'HUGO PAGO LUIS', 'Avenida Ida y vuelta 222, Barrio Centro, Managua', 'Por puerta principal', 'M005 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', 'Coordenadas XXX')")
    suspend fun insertServicioDefaultDos()

}