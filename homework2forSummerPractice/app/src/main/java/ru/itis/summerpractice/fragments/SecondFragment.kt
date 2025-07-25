package ru.itis.summerpractice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.itis.summerpractice.R
import ru.itis.summerpractice.entity.ListPageItemModel

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("model", ListPageItemModel::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getSerializable("model") as? ListPageItemModel
        } ?: return

        val imageView = view.findViewById<ImageView>(R.id.detail_image)
        val titleView = view.findViewById<TextView>(R.id.detail_title)
        val descriptionView = view.findViewById<TextView>(R.id.detail_description)

        Glide.with(this)
            .load(model.imageUrl)
            .into(imageView)

        titleView.text = model.title
        descriptionView.text = model.description
    }
}