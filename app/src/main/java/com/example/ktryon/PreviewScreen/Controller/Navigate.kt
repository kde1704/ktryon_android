package com.example.ktryon.PreviewScreen.Controller

import android.content.Context
import androidx.navigation.NavHostController
import com.example.ktryon.Client.postCheckoutToServer


fun navigateFromPreviewToCheckout(navController: NavHostController, name: String, size: Int, address: String, context: Context) {
    val size_char = when (size) {
        0 -> "S"
        1 -> "M"
        2 -> "L"
        else -> "M"
    }

    postCheckoutToServer(name, size_char, address, context) {
        navController.navigate("Checkout") {
            popUpTo(0)
        }
    }

}