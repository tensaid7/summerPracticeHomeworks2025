package ru.itis.summerpractice.utils

import ru.itis.summerpractice.entity.ListPageItemModel

object DataGenerator {
    public val imageUrls = listOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjHMz0WclFJfDVsxgeHDN-sBeMsYIFUdLkFA&s",
        "https://i.pinimg.com/736x/d8/4a/0d/d84a0d1c04400f6213a6a9c323d90839.jpg",
        "https://i.pinimg.com/1200x/ba/3f/44/ba3f449f90b0c9e8964063fc7d8b8623.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwtEBCf3x7sVfr21vjgNPJUlXnUbPoP_1MGg&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCv7msnPvF9vfJV8mDiMOen5Q7sqKejMl8CWMzXecFj_n3on_nEvtaeVdoynE3mskGimc&usqp=CAU",
    )

    private val titles = listOf(
        "name1",
        "name2",
        "name3",
        "name4",
        "name5",
        "name6"
    )

    private val descriptions = listOf(
        "description1",
        "description2",
        "description3",
        "description4",
        "description5",
        "description6",
    )

    fun generateList(count: Int) : List<ListPageItemModel> {
        return List(count) {
            ListPageItemModel(
                imageUrl = imageUrls.random(),
                title = titles.random(),
                description = descriptions.random()
            )
        }
    }
}