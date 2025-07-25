package ru.itis.summerpractice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.itis.summerpractice.R
import ru.itis.summerpractice.adapter.ListPageAdapter
import ru.itis.summerpractice.entity.ListPageItemModel
import ru.itis.summerpractice.utils.DataGenerator

class FirstFragment : Fragment() {

    private lateinit var adapter: ListPageAdapter
    private lateinit var models: MutableList<ListPageItemModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        models = DataGenerator.generateList(5).toMutableList()

        adapter = ListPageAdapter(models,
            onItemClick = { position ->
                val model = models[position]
                val bundle = Bundle().apply {
                    putSerializable("model", model)
                }
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            },
            onImageClick = { position ->
                val newImage = DataGenerator.imageUrls.random()
                models[position] = models[position].copy(imageUrl = newImage)
                adapter.updateItem(position, models[position])
            }
        )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}