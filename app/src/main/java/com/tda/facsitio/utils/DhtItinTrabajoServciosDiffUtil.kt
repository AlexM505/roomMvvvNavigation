package com.tda.facsitio.utils

import androidx.recyclerview.widget.DiffUtil
import com.tda.facsitio.data.model.DhtItinTrabajoServicio

class DhtItinTrabajoServciosDiffUtil (
    private val oldList: List<DhtItinTrabajoServicio>,
    private val newList: List<DhtItinTrabajoServicio>) : DiffUtil.Callback() {

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
                && oldList[oldItemPosition].idContrato == newList[newItemPosition].idContrato
                && oldList[oldItemPosition].idServicio == newList[newItemPosition].idServicio
                && oldList[oldItemPosition].esServicioTrabajo == newList[newItemPosition].esServicioTrabajo
                && oldList[oldItemPosition].seItinerarioTrabajo == newList[newItemPosition].seItinerarioTrabajo
                && oldList[oldItemPosition].fhInicio == newList[newItemPosition].fhInicio
                && oldList[oldItemPosition].fhFinal == newList[newItemPosition].fhFinal
                && oldList[oldItemPosition].fhEjecucion == newList[newItemPosition].fhEjecucion
                && oldList[oldItemPosition].ccAccionesAsignadas == newList[newItemPosition].ccAccionesAsignadas
                && oldList[oldItemPosition].geoCoordenadas == newList[newItemPosition].geoCoordenadas
                && oldList[oldItemPosition].referenciaAcceso == newList[newItemPosition].referenciaAcceso
                && oldList[oldItemPosition].referenciaCliente == newList[newItemPosition].referenciaCliente
                && oldList[oldItemPosition].referenciaDireccion == newList[newItemPosition].referenciaDireccion
                && oldList[oldItemPosition].referenciaMedidor == newList[newItemPosition].referenciaMedidor
    }

}