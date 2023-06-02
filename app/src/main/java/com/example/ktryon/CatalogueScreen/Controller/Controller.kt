package com.example.ktryon.CatalogueScreen.Controller

import androidx.navigation.NavHostController

fun navigateFromCardToPreview(navController: NavHostController, name: String, price: String, imageUrl: String, tags: List<String>) {
    val no_forward_slash = imageUrl.replace("/", "|")

    val serialized_tags = tags.fold("") { acc, element -> "$acc$element@" }.dropLast(1)
    navController.navigate("Preview/$name/$price/$no_forward_slash/$serialized_tags")
}

