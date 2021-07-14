package com.furkan.marvel.models


data class User(
    val code: Int? = null,
    val status: String? = null,
    val data: Data? = null
)

data class Data(
    val results: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail,
    val description: String,
    val comics: Comics
)

data class Thumbnail(
    val path: String,
    val extension: String
)

data class Comics(
    val available: Int,
    val items: List<ComicsItem>
)

data class ComicsItem(
    val name: String,
    val resourceURI: String
)