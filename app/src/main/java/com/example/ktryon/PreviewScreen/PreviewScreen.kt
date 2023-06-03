package com.example.ktryon.PreviewScreen

import android.content.res.Configuration
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ktryon.GlobalModel.ShopItem
import com.example.ktryon.PreviewScreen.Components.Description
import com.example.ktryon.PreviewScreen.Components.PreviewImage
import com.example.ktryon.PreviewScreen.Components.Tags
import com.example.ktryon.PreviewScreen.Components.TitleAndSize
import com.example.ktryon.PreviewScreen.Components.TryOn
import com.example.ktryon.PreviewScreen.Model.parseTags
import com.example.ktryon.ui.theme.KtryonTheme

import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import com.example.ktryon.PreviewScreen.Components.Checkout
import com.example.ktryon.PreviewScreen.Controller.navigateFromPreviewToCheckout

@Composable
fun PreviewScreen(
    navController: NavHostController? = null,
    name: String,
    imageUrl: String,
    price: String,
    tags: String
) {
    val shopItem = ShopItem(name, price, imageUrl, parseTags(tags))
    var size by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        ElevatedCard {
            PreviewImage(modifier = Modifier.fillMaxWidth(), url = shopItem.imageUrl)
        }

        Spacer(modifier = Modifier.height(32.dp))

        TitleAndSize(
            modifier = Modifier.fillMaxWidth(),
            shopItem = shopItem,
            size = size,
            onSizeChange = { size = it })

        Spacer(modifier = Modifier.height(24.dp))

        Description(
            "A vivacious little piece of attire designed for the high-spirited and effervescent. Discounted during the month of June."
        )

        Spacer(modifier = Modifier.height(24.dp))

        Tags(shopItem.tags, modifier = Modifier.fillMaxWidth())


        Spacer(modifier = Modifier.height(48.dp))

        TryOn(modifier = Modifier.fillMaxWidth(), text = "Try On", shopItem = shopItem)

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier.alpha(0.6f).fillMaxWidth(),
            text = "OR",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Checkout(
            "Checkout",
            onCheckout = {
                if (navController != null) {
                    navigateFromPreviewToCheckout(navController, shopItem.name, shopItem.price, shopItem.imageUrl)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewScreenPreview() {
    KtryonTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            PreviewScreen(
                null,
                "Femboy Skirt",
                "https://kawaiibabe.com/cdn/shop/products/princess-pink-plaid-fur-lined-skirt-xs-bottoms-cosplay-fairy-kei-kawaii-lolita-skirts-ddlg-playground-363_800x.jpg?v=1612736252",
                "$35.50",
                "Tag"
            )
        }
    }
}