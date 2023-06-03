package com.example.ktryon.CatalogueScreen

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavHostController
import com.example.ktryon.CatalogueScreen.Controller.navigateFromCardToPreview
import com.example.ktryon.ui.theme.KtryonTheme
import com.example.ktryon.GlobalModel.ShopItem
import androidx.compose.runtime.*


var items: List<ShopItem> = List(16) {
    if (it % 3 != 0) {
        ShopItem(
            "Femboy Skirt",
            "https://kawaiibabe.com/cdn/shop/products/princess-pink-plaid-fur-lined-skirt-xs-bottoms-cosplay-fairy-kei-kawaii-lolita-skirts-ddlg-playground-363_800x.jpg?v=1612736252",
            "$35.50",
            listOf("Skirt", "Pink", "Ebullient", "Bubbly", "Oh")
        )
    } else {
        ShopItem(
            "Distinguished Tie",
            "https://i.kym-cdn.com/photos/images/newsfeed/002/343/546/d4f.jpg",
            "$12.50",
            listOf("Gentleman", "Man", "Tie", "Handsome", "Emoji")
        )
    }
}

@Composable
fun CatalogueScreen(navController: NavHostController? = null) {
    Column {
        ShopItemGrid(navController = navController)
    }

//    requestShopItems(context = LocalContext.current) {
//        if (it.size != 0) {
//            items = it
//        }
//    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ShopItemGrid(navController: NavHostController?) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items) {
            ShopItemCard(shopItem = it) {
                if (navController != null) {
                    navigateFromCardToPreview(
                        navController = navController,
                        name = it.name,
                        price = it.price,
                        imageUrl = it.imageUrl,
                        tags = it.tags
                    )
                }
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CatalogueScreenPreview() {
    KtryonTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            CatalogueScreen()
        }
    }
}