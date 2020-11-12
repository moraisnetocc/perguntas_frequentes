package br.com.scuad.snowtest.di

import br.com.scuad.snowtest.view.splash.SplashViewModel
import org.koin.dsl.module

val splashModule = module {
    single { SplashViewModel() }
}