package com.project.consultcep.data.db.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.consultcep.domain.model.CepChoiseTable

@Dao
interface CepChoiseDao {

    @Insert
    suspend fun insert(cepChoiseTable: CepChoiseTable)

    @Query("SELECT * FROM cep_choice_table ORDER BY cepId DESC LIMIT 1")
    suspend fun getLastCepRegistered(): CepChoiseTable

    @Query("DELETE FROM cep_choice_table")
    suspend fun clearData()
}