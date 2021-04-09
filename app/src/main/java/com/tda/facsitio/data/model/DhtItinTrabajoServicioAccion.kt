package com.tda.facsitio.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "dht_itin_trabajo_servicio_accion")
data class DhtItinTrabajoServicioAccion (
    @ColumnInfo(name = "ix_itinerario_trabajo") var ixItinerarioTrabajo : String,
    @ColumnInfo(name = "se_itinerario_trabajo") var seItinerarioTrabajo : Int,
    @ColumnInfo(name = "se_trabajo_accion") var seTrabajoAccion : Int,
    @ColumnInfo(name = "id_servicio") var idServicio : Int,
    @ColumnInfo(name = "id_contrato") var idContrato : Int,
    @ColumnInfo(name = "id_trabajo_accion") var idTrabajoAccion : String,
    @ColumnInfo(name = "ti_trabajo_accion") var tiTrabajoAccion : String,
    @ColumnInfo(name = "es_trabajo_accion") var esTrabajoAccion : String,
    @ColumnInfo(name = "referencia_accion") var referenciaAccion : String,
    @ColumnInfo(name = "fl_accion_ejecutada") var flAccionEjecutada : Boolean,
    @ColumnInfo(name = "fl_accion_fallida") var flAccionFallida : Boolean,
    @ColumnInfo(name = "fl_accion_anomala") var flAccionAnomala : Boolean,
    @ColumnInfo(name = "fl_accion_correcta") var flAccionCorrecta : Boolean
        )