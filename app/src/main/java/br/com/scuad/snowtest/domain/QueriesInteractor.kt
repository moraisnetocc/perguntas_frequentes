package br.com.scuad.snowtest.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.scuad.snowtest.data.FakeQueryRepository
import br.com.scuad.snowtest.domain.models.Query

class QueriesInteractor(private val fakeQueryRepository: FakeQueryRepository) {
    private val mutableQueries = MutableLiveData<List<Query>>()
    val queries : LiveData<List<Query>> = mutableQueries

    init {
        initialLoad()
    }

    private fun initialLoad(){
        mutableQueries.postValue(fakeQueryRepository.loadInitialQueries())
    }

    fun saveNewQuery(query: Query){
        val queries = mutableQueries.value!!.toMutableList()
        queries += query
        mutableQueries.postValue(queries)
    }

}