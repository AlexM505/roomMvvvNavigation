package com.tda.facsitio.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tda.facsitio.data.dao.DhtItinTrabajoDao
import com.tda.facsitio.data.dao.DhtItinTrabajoServicioDao
import com.tda.facsitio.data.dao.DhtMedidoresLecturasDao
import com.tda.facsitio.data.model.DhtItinTrabajo
import com.tda.facsitio.data.model.DhtItinTrabajoServicio
import com.tda.facsitio.data.model.DhtMedidoresLecturas

@Database(
    version = 1, exportSchema = false,
    entities = [DhtItinTrabajo::class, DhtItinTrabajoServicio::class, DhtMedidoresLecturas::class]
)
abstract class FactsitioDatabase : RoomDatabase() {

    abstract fun dhtItinTrabajoDao(): DhtItinTrabajoDao
    abstract fun dhtItinTrabajoServicioDao(): DhtItinTrabajoServicioDao
    abstract fun dhtMedidoresLecturasDao(): DhtMedidoresLecturasDao

    companion object{

        @Volatile
        private var INSTANCE : FactsitioDatabase?= null
        private const val DB_NAME = "factsitio_db"

        fun getDatabase(context: Context): FactsitioDatabase{
            val tmpInstance = INSTANCE
            if (tmpInstance != null)
                return tmpInstance

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FactsitioDatabase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}