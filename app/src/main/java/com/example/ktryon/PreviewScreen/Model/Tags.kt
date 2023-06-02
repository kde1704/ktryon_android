package com.example.ktryon.PreviewScreen.Model

fun parseTags(tags: String): List<String> {
    val delimiter = "@"
    return tags.split(delimiter)
}