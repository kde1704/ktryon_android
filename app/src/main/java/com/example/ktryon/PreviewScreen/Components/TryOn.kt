package com.example.ktryon.PreviewScreen.Components

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.example.ktryon.Client.PostTryOnBitmap
import com.example.ktryon.GlobalModel.ShopItem
import com.example.ktryon.PreviewScreen.Controller.chooseImageUriFromGallery

@Composable
fun TryOn(text: String, shopItem: ShopItem) {
    val activityLauncher = chooseImageUriFromGallery {
        PostTryOnBitmap(it, shopItem.name)
    }

    Button(
        onClick = {
            activityLauncher.launch("image/*")
        }
    ) {
        Text(text, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.SemiBold)
    }
}