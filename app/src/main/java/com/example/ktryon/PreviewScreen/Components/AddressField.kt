package com.example.ktryon.PreviewScreen.Components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressField(address: String, onAddressChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(modifier = modifier, value = address, onValueChange = onAddressChange)
}