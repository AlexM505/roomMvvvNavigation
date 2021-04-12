package com.tda.facsitio.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "dht_liquidaciones_consumos",
    primaryKeys = ["id_servicio","fe_consumo","se_consumo","ti_consumo"]
)
data class DhtLiquidacionesConsumos (
    @ColumnInfo(name = "id_servicio") var idServicio : Long,
    @ColumnInfo(name = "fe_consumo") var feConsumo : String,
    @ColumnInfo(name = "se_consumo") var seConsumo : Int,
    @ColumnInfo(name = "ti_consumo") var tiConsumo : String,
    @ColumnInfo(name = "cs_leido") var csLeido : Double,
    @ColumnInfo(name = "cs_liquidado") var csLiquidado : Double,
    @ColumnInfo(name = "cs_estimado") var csEstimado : Double,
    @ColumnInfo(name = "cs_acumulado") var csAcumulado : Double,
    @ColumnInfo(name = "fl_valida") var flValida : Boolean,
    @ColumnInfo(name = "fl_estim_csmo") var flEstimCsmo : Boolean,
    @ColumnInfo(name = "fl_estim_lect") var flEstimLect : Boolean,
    @ColumnInfo(name = "fl_estim_hist") var flEstimHist : Boolean
        )

/*
*  Descripcion de datos
*
* id_servicio >> Identificador del servicio
* fe_consumo >> Fecha de registro de consumo
* se_consumo >> Secuenciador unico
* ti_consumo >> Tipologia del consumo
* cs_leido >> Consumo leido
* cs_liquidado >> Consumo liquidado
* cs_estimado >> Consumo estimado
* cs_acumulado >> Consumo acumulado en estimaciones anteriores
* fl_valida >> Indica si el consumo es valido
* fl_estim_csmo >> Indica si el consumo fue estimado, caso contrario real
* fl_estim_lect >> Indica si la lectura fue estimada, caso contrario real
* fl_estim_hist >> Indica si el consumo es valido para aplicar estimaciones historicas
*
*/