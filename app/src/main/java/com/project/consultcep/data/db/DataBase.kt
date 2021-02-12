package com.project.consultcep.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.consultcep.data.db.Dao.CepChoiseDao
import com.project.consultcep.data.db.Dao.CepHistoryDao
import com.project.consultcep.domain.model.CepChoiseTable
import com.project.consultcep.domain.model.CepHistoryTable

@Database(
    entities = [CepHistoryTable::class, CepChoiseTable::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {

    abstract val cepHistoryDao: CepHistoryDao
    abstract val cepChoiseDao: CepChoiseDao
}