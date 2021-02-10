package com.project.consultcep.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.consultcep.db.Dao.CepHistoryDao
import com.project.consultcep.domain.model.CepHistoryTable

@Database(entities = [CepHistoryTable::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract val cepHistoryDao: CepHistoryDao

    companion object{

        @Volatile
        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "cep_hitory_table"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }


}