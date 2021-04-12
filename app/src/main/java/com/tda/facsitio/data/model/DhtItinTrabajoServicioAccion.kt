package com.tda.facsitio.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "dht_itin_trabajo_servicio_accion",
    primaryKeys = ["ix_itinerario_trabajo", "se_itinerario_trabajo", "se_trabajo_accion"]
)
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


/*
*  Descripcion de datos
*
* ix_itinerario_trabajo >> Identificador del itinerario de trabajo
* se_itinerario_trabajo >> Secuenciador unico del itinerario de trabajo
* se_trabajo_accion >> Secuenciador de la accion para cada servicio
* id_servicio >> Identificador del servicio
* id_contrato >> Identificador del contrato
* id_trabajo_accion >> Identificador de la orden accion, orden de trabajo, etc
* ti_trabajo_accion >> Tipologia de la accion de trabajo
* es_trabajo_accion >> Estado de la accion de trabajo
* referencia_accion >> Referencia sobre la accion de trabajo
* fl_accion_ejecutada >> Indica si la accion fue ejecutada
* fl_accion_fallida >> Indica si la accion fue fallida
* fl_accion_anomala >> Indica si la accion ha sido anomala
* fl_accion_correcta >> Indica si la accion ha sido resuelta de forma correcta
*
*/