package com.tda.facsitio.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "dht_liquidaciones_registros",
    primaryKeys = ["id_servicio","fe_consumo","se_consumo","ti_consumo","se_registro"]
    )
data class DhtLiquidacionesRegistros (
    @ColumnInfo(name = "id_servicio") var idServicio : Long,
    @ColumnInfo(name = "fe_consumo") var feConsumo : String,
    @ColumnInfo(name = "se_consumo") var seConsumo : Int,
    @ColumnInfo(name = "ti_consumo") var tiConsumo : String,
    @ColumnInfo(name = "se_registro") var seRegistro : Int,
    @ColumnInfo(name = "fe_registro") var feRegistro : String,
    @ColumnInfo(name = "cc_dias_registros") var ccDiasRegistros : Int,
    @ColumnInfo(name = "ti_registro_consumo") var tiRegistroConsumo : String,
    @ColumnInfo(name = "cs_leido") var csLeido : Double,
    @ColumnInfo(name = "cs_liquidado") var csLiquidado : Double,
    @ColumnInfo(name = "fl_real") var flReal : Boolean
        )


/*
*  Descripcion de datos
*
* id_servicio >> Identificador del servicio
* fe_consumo >> Fecha en que se registra el consumo
* se_consumo >> Secuenciador de factura de consumo
* ti_consumo >> Tipo de consumo
* se_registro >> Secuenciador de registro
* fe_registro >> Fecha de finalizacion del periodo de consumo registrado
* cc_dias_registrados >> Cantidad de dias que componen el registro
* ti_registro_consumo >> Tipo de registro de consumo
* cs_leido >> Consumo leido
* cs_liquidado >> Consumo liquidado
* fl_real >> Indica si el consumo es real
*
*/