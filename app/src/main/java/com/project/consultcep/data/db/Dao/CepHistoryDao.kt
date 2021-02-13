package com.project.consultcep.data.db.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.consultcep.domain.model.CepHistoryTable

@Dao
interface CepHistoryDao {

    @Insert
    suspend fun insert(cepHistoryTable: CepHistoryTable)

    @Query("SELECT * FROM cep_hitory_table ORDER BY cepHistoryId")
    fun getAllHistory(): LiveData<List<CepHistoryTable>>

    @Query("SELECT * FROM cep_hitory_table WHERE cepHistoryId = :key")
    suspend fun getHistory(key: Long): CepHistoryTable

    @Query("SELECT * FROM cep_hitory_table WHERE cepCode = :key")
    suspend fun getSelectedHistory(key: String): CepHistoryTable

    @Query ("DELETE FROM cep_hitory_table")
    suspend fun clearData()
}

