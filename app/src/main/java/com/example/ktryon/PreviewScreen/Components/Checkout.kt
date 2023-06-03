package com.example.ktryon.PreviewScreen.Components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Checkout(text: String, onCheckout: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = {
            onCheckout()
        }
    ) {
        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
        Spacer(Modifier.width(4.dp))
        Text(text, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.SemiBold)
    }
}