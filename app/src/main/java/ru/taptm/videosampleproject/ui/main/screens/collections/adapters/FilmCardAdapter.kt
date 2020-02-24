package ru.taptm.videosampleproject.ui.main.screens.collections.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import ru.taptm.videosampleproject.R
import ru.taptm.videosampleproject.ui.main.common.extensions.loadWithCash
import ru.taptm.videosampleproject.ui.main.models.Film

class FilmCardAdapter(private val data: ArrayList<Film>) :
    RecyclerView.Adapter<FilmCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_film_card, parent, false)
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.title.text = item.title
        holder.image.loadWithCash(item.imageUrl, VALUE_ROUND_CORNERS)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val image: AppCompatImageView = view.findViewById(R.id.image)
    }

    companion object {
        private const val VALUE_ROUND_CORNERS = 16
    }
}