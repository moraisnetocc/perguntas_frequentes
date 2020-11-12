package br.com.scuad.snowtest.view.main.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.scuad.snowtest.domain.QueriesInteractor
import br.com.scuad.snowtest.domain.models.Query

class QueryListViewModel(private val queriesInteractor: QueriesInteractor) : ViewModel() {

    val queries = queriesInteractor.queries
    val filteredQueries: MutableLiveData<List<Query>> = MutableLiveData<List<Query>>()

    fun filter(text: String) {
        if (text.isEmpty())
            filteredQueries.postValue(queries.value)
        else
            filteredQueries.postValue(queries.value!!.filter { it ->
                it.title.contains(
                    text,
                    true
                )
            })
    }

}