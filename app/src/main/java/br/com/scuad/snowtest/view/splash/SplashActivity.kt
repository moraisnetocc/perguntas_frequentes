package br.com.scuad.snowtest.view.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.scuad.snowtest.R
import br.com.scuad.snowtest.view.main.MainActivity
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupObservers()
        viewModel.checkIfLogged()
    }

    private fun setupObservers() {
        viewModel.viewState.observe(this, Observer { viewState -> handleViewState(viewState) })
    }

    private fun handleViewState(viewState: SplashViewModel.ViewState?) {
        when (viewState) {
            SplashViewModel.ViewState.DONE -> routeToHome()
        }
    }

    private fun routeToHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}