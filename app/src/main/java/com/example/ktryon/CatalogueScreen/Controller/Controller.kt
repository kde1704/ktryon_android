package com.example.ktryon.CatalogueScreen.Controller

import androidx.navigation.NavHostController

fun navigateFromCardToPreview(navController: NavHostController, name: String, price: String, imageUrl: String) {
    val no_forward_slash = imageUrl.replace("/", "|")
    navController.navigate("Preview/$name/$price/$no_forward_slash")
}

