package br.com.scuad.snowtest.view.splash

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel() : ViewModel() {

    enum class ViewState {
        DONE
    }

    private val mutableViewState = MutableLiveData<ViewState>()
    val viewState = mutableViewState

    fun checkIfLogged() { // na vida real a gente vai consultar se o cara ta logado, ou algo assim
        val handler = Handler()
        handler.postDelayed(Runnable {
            mutableViewState.postValue(ViewState.DONE)
        }, 2000)
    }

}