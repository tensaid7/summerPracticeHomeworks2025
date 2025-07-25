package ru.itis.summerpractice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summerpractice.R
import kotlin.random.Random

class MainFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var randomButton: Button

    private lateinit var secondScreenButton : Button

    private val picturesList = listOf(
        "https://images.steamusercontent.com/ugc/1820021756100873397/A3ADEB2A3D8FAA2CF38E7BB361E02187B339F9D4/?imw=637&imh=358&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=true",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjHMz0WclFJfDVsxgeHDN-sBeMsYIFUdLkFA&s",
        "https://i.pinimg.com/736x/d8/4a/0d/d84a0d1c04400f6213a6a9c323d90839.jpg",
        "https://i.pinimg.com/1200x/ba/3f/44/ba3f449f90b0c9e8964063fc7d8b8623.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwtEBCf3x7sVfr21vjgNPJUlXnUbPoP_1MGg&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPWHR_SqBObrG7DVH38JcueXh_wHtTwRk2Cg&s",
        "https://images.genius.com/20a6923ceba2f55ff6ad61796b48cd95.419x419x1.png",
        "https://i.pinimg.com/736x/9a/7c/77/9a7c778662fed913bcb88081de574238.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCv7msnPvF9vfJV8mDiMOen5Q7sqKejMl8CWMzXecFj_n3on_nEvtaeVdoynE3mskGimc&usqp=CAU",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.firstFragmentImageView)
        randomButton = view.findViewById(R.id.random_button)

        imageView.setBackgroundColor(resources.getColor(R.color.the_best_one, null))

        randomButton.setOnClickListener {
            loadPicture()
        }

        secondScreenButton = view.findViewById(R.id.secondScreen_button)

        secondScreenButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }

    }

    private fun loadPicture() {
        val index = Random.nextInt(picturesList.size)
        val imageUrl = picturesList[index]

        Glide.with(requireContext())
            .load(imageUrl)
            .into(imageView)
    }
}
