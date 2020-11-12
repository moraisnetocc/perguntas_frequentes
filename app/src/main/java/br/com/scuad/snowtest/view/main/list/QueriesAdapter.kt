package br.com.scuad.snowtest.view.main.list

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import br.com.scuad.snowtest.R
import br.com.scuad.snowtest.domain.models.Query
import kotlinx.android.synthetic.main.query_item.view.*

class QueriesAdapter() : RecyclerView.Adapter<QueriesAdapter.QueryViewHolder>() {

    private var mutableQueries = listOf<Query>()

    fun submitList(queries: List<Query>) {
        mutableQueries = queries
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.query_item, parent, false)
        return QueryViewHolder(view)
    }

    override fun getItemCount(): Int = mutableQueries.size

    override fun onBindViewHolder(holder: QueryViewHolder, position: Int) {
        holder.onBind(mutableQueries[position])
    }

    inner class QueryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(query: Query) {

            //setup views
            view.title.text = query.title
            view.text.text = query.text
            view.color_tag.setBackgroundColor(
                Color.parseColor(
                    when (query.color) {
                        Query.COLOR.BLUE -> "#3700B3"
                        Query.COLOR.RED -> "#FF0015"
                        Query.COLOR.YELLOW -> "#ffbe00"
                        Query.COLOR.GREEN -> "#00FF22"
                    }
                )
            )

            //expandeCollapse handle
            view.rootView.setOnClickListener {
                if (view.text.visibility == View.GONE) {
                    TransitionManager.beginDelayedTransition(view.llayout)
                    view.text.visibility = View.VISIBLE
                    view.arrow.setImageResource(android.R.drawable.arrow_up_float)
                } else {
                    view.text.visibility = View.GONE
                    view.arrow.setImageResource(android.R.drawable.arrow_down_float)
                }
            }
        }
    }
}