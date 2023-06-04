package com.example.ktryon.PreviewScreen.Components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ktryon.Client.PostTryOnBitmap
import com.example.ktryon.GlobalModel.ShopItem
import com.example.ktryon.PreviewScreen.Controller.chooseImageUriFromGallery

@Composable
fun TryOn(text: String, shopItem: ShopItem, modifier: Modifier = Modifier, onSuccessfulTryOn: (String) -> Unit) {
    val context = LocalContext.current
    val activityLauncher = chooseImageUriFromGallery {
        println("HELP ME")
        PostTryOnBitmap(it, shopItem.name, context, onSuccessfulTryOn)
    }

    Button(
        modifier = modifier,
        onClick = {
            activityLauncher.launch("image/*")
        }
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = null)
        Spacer(Modifier.width(4.dp))
        Text(text, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.SemiBold)
    }
}