package com.tda.facsitio.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dht_itinerarios_trabajo")
data class DhtItinerariosTrabajo (
    @PrimaryKey
    var ixItinerarioTrabajo:String,

    var idMes:Int,
    var esItinerarioTrabajo:String,
    var tiItinerarioTrabajo:String,
    var feGeneracion:String,
    var fePrograma:String,
    var feEjecucion:String,
    var fhApertura:String,
    var fhCierre:String,
    var ccInmuebles:Int,
    var ccContratos:Int,
    var ccServicios:Int,
    var ccAccionesAsignadas:Int,
    var ccAccionesEjecutadas:Int,
    var ccAccionesFallidas:Int,
    var ccAccionesAnomalas:Int,
    var ccAccionesCorrectas:Int,
    var fhAsignacion:String,
    var fhRecepcion:String,
    var idAsignacionMovil:String,
    var idAsignacionUsuario:String,
    var ixInstancia:String
    )