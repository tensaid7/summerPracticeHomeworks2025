package ru.itis.summerpractice.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.itis.summerpractice.R
import ru.itis.summerpractice.entity.ListPageItemModel

class ListPageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val imageView: ImageView = itemView.findViewById(R.id.item_image)
    private val titleView: TextView = itemView.findViewById(R.id.item_title)
    private val descriptionView: TextView = itemView.findViewById(R.id.item_description)

    fun bind(
        model: ListPageItemModel,
        onItemClick: (Int) -> Unit,
        onImageClick: (Int) -> Unit
    ) {
        titleView.text = model.title
        descriptionView.text = model.description
        Glide.with(imageView.context).load(model.imageUrl).into(imageView)

        itemView.setOnClickListener {
            onItemClick(adapterPosition)
        }

        imageView.setOnClickListener {
            onImageClick(adapterPosition)
        }
    }
}