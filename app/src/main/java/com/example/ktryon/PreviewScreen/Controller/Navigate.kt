package com.example.ktryon.PreviewScreen.Controller

import androidx.navigation.NavHostController


fun navigateFromPreviewToCheckout(navController: NavHostController, name: String, price: String, imageUrl: String) {
    val no_forward_slash = imageUrl.replace("/", "|")
    navController.navigate("Checkout/$name/$price/$no_forward_slash")
}