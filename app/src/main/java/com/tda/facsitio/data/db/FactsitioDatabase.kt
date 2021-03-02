package com.tda.facsitio.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tda.facsitio.data.dao.DhtItinerariosTrabajoDao
import com.tda.facsitio.data.model.DhtItinerariosTrabajo

@Database(version = 1, exportSchema = false, entities = [DhtItinerariosTrabajo::class])
abstract class FactsitioDatabase : RoomDatabase() {

    abstract fun dhtItinerariosTrabajoDao(): DhtItinerariosTrabajoDao

    companion object{

        @Volatile
        private var INSTANCE : FactsitioDatabase?= null

        fun getDatabase(context: Context): FactsitioDatabase{
            val tmpInstance = INSTANCE
            if (tmpInstance != null)
                return tmpInstance

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FactsitioDatabase::class.java,
                    "factsitio_db"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}