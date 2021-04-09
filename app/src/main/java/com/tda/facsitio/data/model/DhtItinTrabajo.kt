package com.tda.facsitio.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dht_itin_trabajo")
data class DhtItinTrabajo (
    @PrimaryKey
    @ColumnInfo(name = "ix_itinerario_trabajo") var ixItinerarioTrabajo:String,
    @ColumnInfo(name = "id_mes") var idMes:Int,
    @ColumnInfo(name = "es_itinerario_trabajo") var esItinerarioTrabajo:String,
    @ColumnInfo(name = "ti_itinerario_trabajo") var tiItinerarioTrabajo:String,
    @ColumnInfo(name = "fe_generacion") var feGeneracion:String,
    @ColumnInfo(name = "fe_programa") var fePrograma:String,
    @ColumnInfo(name = "fe_ejecucion") var feEjecucion:String,
    @ColumnInfo(name = "fh_apertura") var fhApertura:String,
    @ColumnInfo(name = "fh_cierre") var fhCierre:String,
    @ColumnInfo(name = "cc_inmuebles") var ccInmuebles:Int,
    @ColumnInfo(name = "cc_contratos") var ccContratos:Int,
    @ColumnInfo(name = "cc_servicios") var ccServicios:Int,
    @ColumnInfo(name = "cc_acciones_asignadas") var ccAccionesAsignadas:Int,
    @ColumnInfo(name = "cc_acciones_ejecutadas") var ccAccionesEjecutadas:Int,
    @ColumnInfo(name = "cc_acciones_fallidas") var ccAccionesFallidas:Int,
    @ColumnInfo(name = "cc_acciones_anomalas") var ccAccionesAnomalas:Int,
    @ColumnInfo(name = "cc_acciones_correctas") var ccAccionesCorrectas:Int,
    @ColumnInfo(name = "fh_asignacion") var fhAsignacion:String,
    @ColumnInfo(name = "fh_recepcion") var fhRecepcion:String,
    @ColumnInfo(name = "id_asignacion_movil") var idAsignacionMovil:String,
    @ColumnInfo(name = "id_asignacion_usuario") var idAsignacionUsuario:String
    )