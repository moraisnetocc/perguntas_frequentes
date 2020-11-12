package br.com.scuad.snowtest

import android.app.Application
import br.com.scuad.snowtest.di.appModule
import br.com.scuad.snowtest.di.mainModule
import br.com.scuad.snowtest.di.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    splashModule,
                    mainModule
                )
            )
        }
    }
}