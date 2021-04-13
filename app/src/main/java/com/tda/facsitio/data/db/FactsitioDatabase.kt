package com.tda.facsitio.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tda.facsitio.data.dao.DhtItinTrabajoDao
import com.tda.facsitio.data.model.DhtItinTrabajo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(version = 1, exportSchema = false, entities = [DhtItinTrabajo::class])
abstract class FactsitioDatabase : RoomDatabase() {

    abstract fun dhtItinTrabajoDao(): DhtItinTrabajoDao

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