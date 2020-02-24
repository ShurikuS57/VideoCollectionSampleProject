package ru.taptm.videosampleproject.ui.main.screens.collections.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.taptm.videosampleproject.R
import ru.taptm.videosampleproject.ui.main.common.extensions.itemPadding
import ru.taptm.videosampleproject.ui.main.models.RowCollection

class RowCollectionAdapter(private var data: List<RowCollection>) :
    RecyclerView.Adapter<RowCollectionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_film_collection, parent, false)
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.title.text = item.title
        holder.recyclerView.setHasFixedSize(true)
        holder.recyclerView.adapter = FilmCardAdapter(item.filmList)
        holder.recyclerView.itemPadding(PADDING_FILM_ITEM)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.text_title_collection)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_films)
    }

    companion object {
        private const val PADDING_FILM_ITEM = 5
    }
}