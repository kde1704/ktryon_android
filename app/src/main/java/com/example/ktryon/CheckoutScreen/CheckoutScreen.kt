package com.example.ktryon.CheckoutScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CheckoutScreen(
    navController: NavHostController? = null,
    name: String,
    imageUrl: String,
    price: String,
) {

    Column(
        modifier = Modifier.padding(54.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(name)
        Text(imageUrl)
        Text(price)
    }
}