package com.tda.facsitio.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "dht_medidores_lecturas",
    primaryKeys = ["ix_medidor","fh_lectura","fe_consumo","ti_consumo","se_consumo"]
)
data class DhtMedidoresLecturas (
    @ColumnInfo(name = "ix_medidor") var ixMedidor : String,
    @ColumnInfo(name = "fh_lectura") var fhLectura : String,
    @ColumnInfo(name = "fe_consumo") var feConsumo : String,
    @ColumnInfo(name = "fe_liquidacion") var feLiquidacion : String,
    @ColumnInfo(name = "id_lectura_tipo") var idLecturaTipo : String,
    @ColumnInfo(name = "registro_campo") var registroCampo : Long,
    @ColumnInfo(name = "registro_sistema") var registroSistema : Long,
    @ColumnInfo(name = "id_anomalia_lectura") var idAnomaliaLectura : String,
    @ColumnInfo(name = "id_anomalia_complemento") var idAnomaliaComplemento : String,
    @ColumnInfo(name = "cm_lectura") var cmLectura : String,
    @ColumnInfo(name = "fl_vuelta") var flVuelta : Boolean,
    @ColumnInfo(name = "ti_consumo") var tiConsumo : String,
    @ColumnInfo(name = "id_servicio") var idServicio : Long,
    @ColumnInfo(name = "fe_consumo_aplicado") var feConsumoAplicado : String,
    @ColumnInfo(name = "se_consumo") var seConsumo : Int
        )


/*
*  Descripcion de datos
*
* ix_medidor >> Identificador unico del medidor
* fh_lectura >> Fecha y hora de la lectura en campo
* fe_consumo >> Fecha en que se registra el consumo
* fe_liquidacion >> Fecha de liquidacion del consumo leido
* id_lectura_tipo >> Tipo de registro de lectura
* registro_campo >> Registro en campo de la lectura
* registro_sistema >> Registro en sistema de la lectura
* id_anomalo_lectura >> Tipo de anomalia de lectura identificado en campo
* id_anomalia_complemento >> Valor complementario codificado de la anomalia de lectura
* cm_lectura >> Comentario de la lectura
* fl_vuelta >> Indica si se presento una vuelta de medidor
* ti_consumo >> Tipo de consumo medido
* id_servicio >> Identificador del servicio
* fe_consumo_aplicado >> Fecha del siguiente periodo de consumo realizado
* se_consumo >> Secuenciador de consumo
*
*/