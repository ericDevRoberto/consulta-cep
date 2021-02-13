package com.project.consultcep.di

import com.project.consultcep.presentation.consultFragment.ConsultViewModel
import com.project.consultcep.presentation.historyFragment.HistoryViewModel
import com.project.consultcep.presentation.homeFragment.HomeViewModel
import com.project.consultcep.presentation.selectedCepFragment.SelectedCepViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModules = module {

    viewModel {
        HomeViewModel(dataBase =  get())
    }

    viewModel {
        ConsultViewModel(
            dbCep = get(),
            dataBase = get()
        )
    }

    viewModel {
        HistoryViewModel(
            get(),
            dataBase = get()
        )
    }

    viewModel {
        SelectedCepViewModel(
            get(),
            dbHistory = get()
        )
    }
}