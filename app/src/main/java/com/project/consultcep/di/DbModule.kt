package com.project.consultcep.di

import androidx.room.Room
import com.project.consultcep.data.db.DataBase
import org.koin.dsl.module

private const val NAME_DATA_BASE = "cep_history_table"

val DbModule = module {

    single {
        Room.databaseBuilder(
            get(),
            DataBase::class.java,
            NAME_DATA_BASE
        ).build()
    }

    single { get<DataBase>().cepHistoryDao }
    single { get<DataBase>().cepChoiseDao }
}