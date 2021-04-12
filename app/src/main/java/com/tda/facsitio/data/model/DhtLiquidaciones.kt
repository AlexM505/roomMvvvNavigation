package com.tda.facsitio.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "dht_liquidaciones",
    primaryKeys = ["id_servicio", "fe_consumo", "se_consumo"]
)
data class DhtLiquidaciones (
    @ColumnInfo(name = "id_servicio") var idServicio : Long,
    @ColumnInfo(name = "id_contrato") var idContrato : Long,
    @ColumnInfo(name = "fe_consumo") var feConsumo : String,
    @ColumnInfo(name = "se_consumo") var seConsumo : Int,
    @ColumnInfo(name = "es_liquidacion") var esLiquidacion : String,
    @ColumnInfo(name = "fe_liquidacion") var feLiquidacion : String,
    @ColumnInfo(name = "fe_anulacion") var feAnulacion : String,
    @ColumnInfo(name = "fe_consumo_anterior") var feConsumoAnterior : String,
    @ColumnInfo(name = "fe_consumo_ureal") var feConsumoUReal : String,
    @ColumnInfo(name = "fe_consumo_uliquidado") var feConsumoULiquidado : String,
    @ColumnInfo(name = "fl_valida") var flValida : Boolean,
    @ColumnInfo(name = "fl_estim_csmo") var flEstimCsmo : Boolean,
    @ColumnInfo(name = "fl_estim_lect") var flEstimLect : Boolean,
    @ColumnInfo(name = "fl_estim_hist") var flEstimHist : Boolean
        )

/*
*  Descripcion de datos
*
* id_servicio >> Identificador del servicio
* id_contrato >> Identificador del contrato
* fe_consumo >> Fecha en que se registra el consumo
* se_consumo >> Secuenciador de factura de consumo
* es_liquidacion >> Estado de la liquidacion
* fe_liquidacion >> Fecha en que se realiza la liquidacion
* fe_anulacion >> Fecha en que se realiza la anulacion de la liquidacion
* fe_consumo_anterior >> Fecha de registro del consumo anterior
* fe_consumo_ureal >> Fecha del ultimo registro de consumo real
* fe_consumo_uliquidado >> Fecha de ultimo consumo liquidado
* fl_valida >> Indica si el consumo es valido
* fl_estim_csmo >> Indica si el consumo fue estimado, caso contrario real
* fl_estim_lect >> Indica si la lectura fue estimado, caso contrario real
* fl_estim_hist >> Indica si el consumo es valido para aplicar estimaciones historicas
*
*/