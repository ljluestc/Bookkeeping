package com.hannah.demo.ui.bookkeeping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hannah.demo.R
import com.hannah.demo.ui.bookkeeping.dummy.DummyItem

/**
 * AUTHOR: Hannah
 * DATE: 2020-11-09
 */
class BookkeepingAdapter(private val values: List<DummyItem>): RecyclerView.Adapter<BookkeepingAdapter.ViewHolder>() {

    private val onClickListener : View.OnClickListener

    init {
        onClickListener = View.OnClickListener {view ->
            val item = view.tag as DummyItem
            Toast.makeText(view.context, item.content, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bookkeeping_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
        with(holder.itemView){
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.id_text)
        val contentView: TextView = view.findViewById(R.id.content)
    }
}