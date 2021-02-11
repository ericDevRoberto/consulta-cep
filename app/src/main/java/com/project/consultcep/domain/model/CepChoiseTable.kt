package com.project.consultcep.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cep_choice_table")
class CepChoiseTable {

    @PrimaryKey(autoGenerate = true)
    var cepId: Long = 0L

    @ColumnInfo(name = "cepChoose")
    var cepChoose : String = String()
}