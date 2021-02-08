package com.project.consultcep.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cep_hitory_table")
class CepHistoryTable {

    @PrimaryKey(autoGenerate = true)
    var cepHistoryId: Long = 0L

    @ColumnInfo(name = "cepCode")
    var cepCode: String = String()

    @ColumnInfo(name = "cepState")
    var cepState: String = String()

    @ColumnInfo(name = "cepCity")
    var cepCity: String = String()

    @ColumnInfo(name = "cepDistrict")
    var cepDistrict: String = String()

    @ColumnInfo(name = "cepAddress")
    var cepAddress: String = String()
}