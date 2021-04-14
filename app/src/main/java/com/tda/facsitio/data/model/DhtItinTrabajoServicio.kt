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
    @ColumnInfo(name = "es_servicio_trabajo") var esServicioTrabajo : String,
    @ColumnInfo(name = "geo_coordenadas") var geoCoordenadas : String
        )


/*
*  Descripcion de datos
*
* ix_itinerario_trabajo >> Identificador del itinerario de trabajo
* id_mes >> Mes del itinerario de trabajo
* se_itinerario_trabajo >> Secuenciador unico del itinerario de trabajo
* id_servicio >> Identificador del servicio
* id_contrato >> Identificador del contrato
* referencia_cliente >> Informacion del cliente a visiatar
* referencia_direccion >> Informacion de la direccion de visita
* referencia_acceso >> Referencia de acceso interno
* referencia_medidor >> Informacion de referencia del medidor
* fh_ejecucion >> Fecha y hora de ejecucion del trabajp
* fh_inicio >> Fecha y hora inicial de los trabajos realizados
* fh_final >> Fecha y hora final de los trabajos realizados
* cc_acciones_asignadas >> Cantidad de acciones asiganadas
* es_servicio_trabajo >> Estado de los trabajos realizados
* geo_coordenadas >> Coordenadas geograficas del servicio
*
*/