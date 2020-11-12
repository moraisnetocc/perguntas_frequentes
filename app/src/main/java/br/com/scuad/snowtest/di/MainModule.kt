package br.com.scuad.snowtest.di

import br.com.scuad.snowtest.data.FakeQueryRepository
import br.com.scuad.snowtest.domain.QueriesInteractor
import br.com.scuad.snowtest.view.main.addquery.AddQueryViewModel
import br.com.scuad.snowtest.view.main.list.QueryListViewModel
import org.koin.dsl.module

val mainModule = module {
    single { FakeQueryRepository() }
    single { QueriesInteractor(get()) }

    single { AddQueryViewModel(get()) }
    single { QueryListViewModel(get()) }
}