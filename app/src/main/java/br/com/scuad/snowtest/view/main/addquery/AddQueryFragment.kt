package br.com.scuad.snowtest.view.main.addquery

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.scuad.snowtest.R
import br.com.scuad.snowtest.domain.models.Query.COLOR
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_query.*
import org.koin.android.ext.android.inject


class AddQueryFragment : Fragment(R.layout.fragment_add_query) {

    private val viewModel: AddQueryViewModel by inject()

    var selectedColor: COLOR = COLOR.BLUE

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        requireActivity().title = "Adicionar Pergunta"
    }

    private fun setupListeners() {
        blue_selector.setOnClickListener { handleSelector(COLOR.BLUE) }
        red_selector.setOnClickListener { handleSelector(COLOR.RED) }
        yellow_selector.setOnClickListener { handleSelector(COLOR.YELLOW) }
        green_selector.setOnClickListener { handleSelector(COLOR.GREEN) }
        add_query_bt.setOnClickListener { sendNewQuery() }
    }

    private fun sendNewQuery() {
        if (etTitle.text.isNullOrEmpty() or etText.text.isNullOrEmpty()) {
            showSnackBar("Faltando informações :(")
            return
        }
        viewModel.saveQuery(
            etTitle.text.toString(),
            etText.text.toString(),
            selectedColor
        )

        finish()
    }

    private fun handleSelector(color: COLOR) {
        cleanCurrentSelection()
        selectedColor = color
        when (color) {
            COLOR.BLUE -> blue_selector.setImageResource(R.drawable.ic_check_mark_black_outline)
            COLOR.RED -> red_selector.setImageResource(R.drawable.ic_check_mark_black_outline)
            COLOR.YELLOW -> yellow_selector.setImageResource(R.drawable.ic_check_mark_black_outline)
            COLOR.GREEN -> green_selector.setImageResource(R.drawable.ic_check_mark_black_outline)
        }
    }

    private fun cleanCurrentSelection() {
        blue_selector.setImageDrawable(null)
        red_selector.setImageDrawable(null)
        yellow_selector.setImageDrawable(null)
        green_selector.setImageDrawable(null)
    }

    private fun finish() {
        showSnackBar("Pergunta adicionada com sucesso")
        findNavController().navigateUp()
    }

    private fun showSnackBar(text: String) {
        Snackbar.make(
            requireActivity().findViewById(R.id.main_layout),
            text,
            Snackbar.LENGTH_SHORT
        ).apply {
            this.view.setBackgroundColor(Color.parseColor("#2F913C"))
        }.show()
    }

}