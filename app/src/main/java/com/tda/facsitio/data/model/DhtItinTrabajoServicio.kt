package com.tda.facsitio.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "dht_itin_trabajo_servicio",
    primaryKeys = ["ix_itinerario_trabajo", "se_itinerario_trabajo"]
)
data class DhtItinTrabajoServicio (
    @ColumnInfo(name = "ix_itinerario_trabajo") var ixItinerarioTrabajo : String,
    @ColumnInfo(name = "id_mes") var idMes : Int,
    @ColumnInfo(name = "se_itinerario_trabajo") var seItinerarioTrabajo : Int,
    @ColumnInfo(name = "id_servicio") var idServicio : Long,
    @ColumnInfo(name = "id_contrato") var idContrato : Long,
    @ColumnInfo(name = "referencia_cliente") var referenciaCliente : String,
    @ColumnInfo(name = "referencia_direccion") var referenciaDireccion : String,
    @ColumnInfo(name = "referencia_acceso") var referenciaAcceso : String,
    @ColumnInfo(name = "referencia_medidor") var referenciaMedidor : String,
    @ColumnInfo(name = "fh_ejecucion") var fhEjecucion : String,
    @ColumnInfo(name = "fh_inicio") var fhInicio : String,
    @ColumnInfo(name = "fh_final") var fhFinal : String,
    @ColumnInfo(name = "cc_acciones_asignadas") var ccAccionesAsignadas : String,
    @ColumnInfo(name = "geo_coordenadas") var geoCoordenadas : String
        )