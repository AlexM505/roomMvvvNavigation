package com.tda.facsitio.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "dht_itin_trabajo")
@Parcelize
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
    ) : Parcelable

/*
*  Descripcion de datos
*
* ix_itinerario_trabajo >> Identificador unico del itinerario de trabajo
* id_mes >> Identificador del mes de trabajo
* es_itinerario_trabajo >> Estado del itinerario de trabajo
* ti_itinerario_trabajo >> Tipologia del itinerario de trabajo
* fe_generacion >> Fecha de generacion del itinerario de trabajo
* fe_programa >> Fecha de programacion del itinerario de trabajo
* fe_ejecucion >> Fecha de ejecucion del itinerario de trabajo
* fh_apertura >> Fecha y hora de la apertura del itinerario
* fh_cierre >> Fecha y hora del cierre del itinerario
* cc_inmuebles >> Cantidad de inmuebles incluidos en el itinerario
* cc_contratos >> Cantidad de contratos incluidos en el itinerario
* cc_servicios >> Cantidad de servicios incluidos en el itinerario
* cc_acciones_asignadas >> Cantidad de acciones asignadas en el itinerario
* cc_acciones_ejecutadas >> Cantidad de acciones ejecutadas en el itinerario
* cc_acciones_fallidas >> Cantidad de acciones fallidas en el itinerario
* cc_acciones_anomalas >> Cantidad de acciones anomalas en el itinerario
* cc_acciones_correctas >> Cantidad de acciones correctas en el itinerario
* fh_asignacion >> Fecha y hora de asignacion del itinerario al movil
* fh_recepcion >> Fecha y hora de la recepcion del itinerario
* id_asigancion_movil >> Identificador del equipo movil al que se asigno el itinerario
* id_asignacion_usuario >> Identificador del usuario al que se le asigno el itinerario
*
*/