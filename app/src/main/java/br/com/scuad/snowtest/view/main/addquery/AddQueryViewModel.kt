package br.com.scuad.snowtest.view.main.addquery

import androidx.lifecycle.ViewModel
import br.com.scuad.snowtest.domain.QueriesInteractor
import br.com.scuad.snowtest.domain.models.Query

class AddQueryViewModel(private val queriesInteractor: QueriesInteractor): ViewModel() {

    fun saveQuery(title: String, text: String, type: Query.COLOR){
        queriesInteractor.saveNewQuery(
            Query(title, text, type)
        )
    }

}