package ru.itis.summerpractice.entity

import java.io.Serializable

data class ListPageItemModel (
    var imageUrl : String,
    val title : String,
    val description : String
) : Serializable