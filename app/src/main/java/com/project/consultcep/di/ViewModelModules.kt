package com.project.consultcep.di

import com.project.consultcep.ui.consultFragment.ConsultViewModel
import com.project.consultcep.ui.historyFragment.HistoryViewModel
import com.project.consultcep.ui.homeFragment.HomeViewModel
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