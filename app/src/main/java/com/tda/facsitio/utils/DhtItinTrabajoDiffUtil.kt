package com.tda.facsitio.utils

import androidx.recyclerview.widget.DiffUtil
import com.tda.facsitio.data.model.DhtItinTrabajo

class DhtItinTrabajoDiffUtil(
        private val oldList: List<DhtItinTrabajo>,
        private val newList: List<DhtItinTrabajo>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].ixItinerarioTrabajo == newList[newItemPosition].ixItinerarioTrabajo
                && oldList[oldItemPosition].idMes == newList[newItemPosition].idMes
                && oldList[oldItemPosition].tiItinerarioTrabajo == newList[newItemPosition].tiItinerarioTrabajo
                && oldList[oldItemPosition].esItinerarioTrabajo == newList[newItemPosition].esItinerarioTrabajo
                && oldList[oldItemPosition].idAsignacionUsuario == newList[newItemPosition].idAsignacionUsuario
                && oldList[oldItemPosition].idAsignacionMovil == newList[newItemPosition].idAsignacionMovil
                && oldList[oldItemPosition].feGeneracion == newList[newItemPosition].feGeneracion
                && oldList[oldItemPosition].fePrograma == newList[newItemPosition].fePrograma
                && oldList[oldItemPosition].feEjecucion == newList[newItemPosition].feEjecucion
                && oldList[oldItemPosition].fhApertura == newList[newItemPosition].fhApertura
                && oldList[oldItemPosition].fhAsignacion == newList[newItemPosition].fhAsignacion
                && oldList[oldItemPosition].fhRecepcion == newList[newItemPosition].fhRecepcion
                && oldList[oldItemPosition].fhCierre == newList[newItemPosition].fhCierre
                && oldList[oldItemPosition].ccServicios == newList[newItemPosition].ccServicios
                && oldList[oldItemPosition].ccContratos == newList[newItemPosition].ccContratos
                && oldList[oldItemPosition].ccInmuebles == newList[newItemPosition].ccInmuebles
                && oldList[oldItemPosition].ccAccionesAsignadas == newList[newItemPosition].ccAccionesAsignadas
                && oldList[oldItemPosition].ccAccionesEjecutadas == newList[newItemPosition].ccAccionesEjecutadas
                && oldList[oldItemPosition].ccAccionesCorrectas == newList[newItemPosition].ccAccionesCorrectas
                && oldList[oldItemPosition].ccAccionesFallidas == newList[newItemPosition].ccAccionesFallidas
                && oldList[oldItemPosition].ccAccionesAnomalas == newList[newItemPosition].ccAccionesAnomalas
    }


}