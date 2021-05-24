package com.tda.facsitio.data.dao

import androidx.room.*
import com.tda.facsitio.data.model.DhtMedidoresLecturas

@Dao
interface DhtMedidoresLecturasDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMedidorLectura(vararg dhtMedidoresLecturas: DhtMedidoresLecturas)

    @Update
    suspend fun updateMedidorLectura(dhtMedidoresLecturas: DhtMedidoresLecturas)

    @Query("DELETE FROM dht_medidores_lecturas")
    suspend fun deleteAll()

    @Query("SELECT * FROM dht_medidores_lecturas WHERE id_servicio = :servicio")
    fun obtenerLecturasByServicio(servicio: Long): List<DhtMedidoresLecturas>

    @Query("INSERT INTO dht_medidores_lecturas (ix_medidor, fh_lectura, fe_consumo, fe_liquidacion, id_lectura_tipo, registro_campo, registro_sistema, id_anomalia_lectura, id_anomalia_complemento, cm_lectura, fl_vuelta, ti_consumo, id_servicio, fe_consumo_aplicado, se_consumo) " +
            "VALUES ('M002', '2010-02-25 00:00:00.000000', '1900-01-01 00:00:00.000000', '1900-01-01 00:00:00.000000', 'CICLO', 555, 555, ' ', ' ', 'Segunda lectura en ciclo', false, 'EACTN', 105, '2999-12-31 00:00:00.000000', 0)")
    suspend fun insertMedLectDefaultUno()
}