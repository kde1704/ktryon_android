package com.example.ktryon.PreviewScreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ktryon.GlobalModel.ShopItem
import com.example.ktryon.PreviewScreen.Components.Description
import com.example.ktryon.PreviewScreen.Components.PreviewImage
import com.example.ktryon.PreviewScreen.Components.Tags
import com.example.ktryon.PreviewScreen.Components.TitleAndSize
import com.example.ktryon.PreviewScreen.Model.parseTags
import com.example.ktryon.ui.theme.KtryonTheme

@Composable
fun PreviewScreen(
    navController: NavHostController? = null,
    name: String,
    price: String,
    imageUrl: String,
    tags: String
) {
    val shopItem = ShopItem(name, price, imageUrl, parseTags(tags))

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        ElevatedCard {
            PreviewImage(modifier = Modifier.fillMaxWidth(), url = shopItem.imageUrl)
        }

        Spacer(modifier = Modifier.height(32.dp))

        TitleAndSize(modifier = Modifier.fillMaxWidth(), shopItem = shopItem)

        Spacer(modifier = Modifier.height(32.dp))

        Description("A vivacious little piece of attire designed for the high-spirited and effervescent. Discounted during the month of June.")

        Spacer(modifier = Modifier.height(32.dp))

        Tags(shopItem.tags, modifier = Modifier.fillMaxWidth())
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
                "$35.50",
                "https://kawaiibabe.com/cdn/shop/products/princess-pink-plaid-fur-lined-skirt-xs-bottoms-cosplay-fairy-kei-kawaii-lolita-skirts-ddlg-playground-363_800x.jpg?v=1612736252",
                ""
            )
        }
    }
}