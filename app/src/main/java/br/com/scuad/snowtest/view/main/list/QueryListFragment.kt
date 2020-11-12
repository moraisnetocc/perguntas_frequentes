package br.com.scuad.snowtest.view.main.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.scuad.snowtest.R
import br.com.scuad.snowtest.domain.models.Query
import kotlinx.android.synthetic.main.fragment_query_list.*
import org.koin.android.ext.android.inject


class QueryListFragment : Fragment(R.layout.fragment_query_list),
    android.widget.SearchView.OnQueryTextListener {

    private val viewModel: QueryListViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = "Perguntas Frequentes"

        setupRV()
        setupListeners()
        setupObservers()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)

        val mSearchView: android.widget.SearchView = menu.findItem(R.id.search)
            .actionView as android.widget.SearchView

        mSearchView.queryHint = "Procurar perguntas"

        mSearchView.setOnQueryTextListener(this)
    }

    private fun setupRV() {
        queries_rv.adapter = QueriesAdapter()
    }

    private fun setupListeners() {
        add_query_bt.setOnClickListener { routeToAddQuery() }
    }

    private fun setupObservers() {
        viewModel.filteredQueries.observe(viewLifecycleOwner, Observer { queries -> submitList(queries) })
        viewModel.queries.observe(viewLifecycleOwner, Observer { viewModel.filter("") })
    }

    private fun submitList(queries: List<Query>) {
        (queries_rv.adapter as QueriesAdapter).submitList(queries)
    }

    private fun routeToAddQuery() {
        findNavController().navigate(R.id.action_queryListFragment_to_addQueryFragment)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(query: String?): Boolean {
        viewModel.filter(query ?: "")
        return true
    }

}