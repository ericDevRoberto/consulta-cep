package com.project.consultcep.di

import com.project.consultcep.presentation.consultFragment.ConsultViewModel
import com.project.consultcep.presentation.historyFragment.HistoryViewModel
import com.project.consultcep.presentation.homeFragment.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModules = module {

    viewModel {
        HomeViewModel(dataBase =  get())
    }

    viewModel {
        HistoryViewModel(
            dataBase = get()
        )
    }

    viewModel {
        ConsultViewModel(
            dbCep = get(),
            dataBase = get()
        )
    }
}