package com.tda.facsitio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tda.facsitio.data.model.DhtItinTrabajoServicio

@Dao
interface DhtItinTrabajoServicioDao {

    @Query("SELECT * FROM dht_itin_trabajo_servicio WHERE ix_itinerario_trabajo = :itinerario ORDER BY id_servicio ASC")
    suspend fun allServiciosByItin(itinerario : String): List<DhtItinTrabajoServicio>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertServicio(vararg itinerarioTrabajo: DhtItinTrabajoServicio)

    @Update
    suspend fun updateServicio(itinerarioTrabajo: DhtItinTrabajoServicio)

    @Query("DELETE FROM dht_itin_trabajo_servicio")
    suspend fun deleteAll()

    @Query("SELECT * FROM dht_itin_trabajo_servicio WHERE id_servicio LIKE :searchQuery")
    fun searchServiciosDb(searchQuery: String): LiveData<List<DhtItinTrabajoServicio>>

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 2, 105, 105, 'MARIA GONZALEZ PEREZ', 'Calle Libertador 333, Barrio Centro, Managua', 'Por puerta principal', 'M002 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', '12.102613,-86.262795')")
    suspend fun insertServicioDefaultUno()

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 3, 106, 106, 'HUGO PAGO LUIS', 'Avenida Ida y vuelta 222, Barrio Centro, Managua', 'Por puerta principal', 'M005 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', '12.102702,-86.262051')")
    suspend fun insertServicioDefaultDos()

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 4, 107, 107, 'Rodolfo Gutierrez Ortega', 'Avenida Ida y vuelta 222, Barrio Centro, Managua', 'Por puerta principal', 'M005 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', '12.102663,-86.264933')")
    suspend fun insertServicioDefaultTres()

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 5, 108, 108, 'MYKELL FLORES APELLIDO', 'Avenida Ida y vuelta 222, Barrio Centro, Managua', 'Por puerta principal', 'M002 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', '12.103179,-86.264036')")
    suspend fun insertServicioDefaultCuatro()

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 6, 109, 109, 'JORGE MORALES JUNIOR', 'Avenida Ida y vuelta 222, Barrio Centro, Managua', 'Por puerta principal', 'M004 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', '12.103363,-86.262656')")
    suspend fun insertServicioDefaultCinco()

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 7, 110, 110, 'JOE GOMEZ ALVAREZ', 'Avenida Ida y vuelta 222, Barrio Centro, Managua', 'Por puerta principal', 'M005 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', '12.103651,-86.263509')")
    suspend fun insertServicioDefaultSeis()

    @Query("insert into dht_itin_trabajo_servicio (ix_itinerario_trabajo, id_mes, se_itinerario_trabajo, id_servicio, id_contrato, referencia_cliente, referencia_direccion, referencia_acceso, referencia_medidor, fh_ejecucion, fh_inicio, fh_final, cc_acciones_asignadas, es_servicio_trabajo, geo_coordenadas) " +
            "values ('202001100-02-LECT', 202101, 8, 111, 111, 'ANA CLARA MENDOZA', 'Avenida Ida y vuelta 222, Barrio Centro, Managua', 'Por puerta principal', 'M006 - ABB', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 1, 'PENDI', '12.102812,-86.260854')")
    suspend fun insertServicioDefaultSiete()

}