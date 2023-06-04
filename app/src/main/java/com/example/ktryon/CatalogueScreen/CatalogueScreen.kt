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
import androidx.compose.ui.platform.LocalContext
import com.example.ktryon.Client.RequestShopItems


var items: List<ShopItem> = List(16) {
    ShopItem(
        "",
        "https://images.unsplash.com/photo-1585314062340-f1a5a7c9328d?width=480",
        "",
        listOf("")
    )
}

@Composable
fun CatalogueScreen(navController: NavHostController? = null) {
    Column {
        ShopItemGrid(navController = navController)
    }

    RequestShopItems(context = LocalContext.current) {
        if (it.isNotEmpty()) {
            items = it
        }
    }
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