package com.example.ktryon.Catalogue

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ktryon.ShopItem.ShopItem
import com.example.ktryon.ui.theme.KtryonTheme


val items: List<ShopItem> = List(16) {
    if (it % 3 != 0) {
        ShopItem(
            "Femboy Skirt",
            "$35.50",
            "https://kawaiibabe.com/cdn/shop/products/princess-pink-plaid-fur-lined-skirt-xs-bottoms-cosplay-fairy-kei-kawaii-lolita-skirts-ddlg-playground-363_800x.jpg?v=1612736252"
        )
    } else {
        ShopItem(
            "Distinguished Tie",
            "$12.50",
            "https://i.kym-cdn.com/photos/images/newsfeed/002/343/546/d4f.jpg"
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CatalogueScreen() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items) {
            ShopItemCard(shopItem = it)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ShopItemCardPreview() {
    KtryonTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            CatalogueScreen()
        }
    }
}