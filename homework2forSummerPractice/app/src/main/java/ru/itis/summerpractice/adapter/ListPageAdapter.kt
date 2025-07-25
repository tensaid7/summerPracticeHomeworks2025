package ru.itis.summerpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.summerpractice.R
import ru.itis.summerpractice.entity.ListPageItemModel
import ru.itis.summerpractice.viewholder.ListPageViewHolder

class ListPageAdapter(
    private val items: MutableList<ListPageItemModel>,
    private val onItemClick: (Int) -> Unit,
    private val onImageClick: (Int) -> Unit
) : RecyclerView.Adapter<ListPageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_page, parent, false)
        return ListPageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListPageViewHolder, position: Int) {
        holder.bind(items[position], onItemClick, onImageClick)
    }

    override fun getItemCount(): Int = items.size

    fun updateItem(position: Int, newModel: ListPageItemModel) {
        items[position] = newModel
        notifyItemChanged(position)
    }
}