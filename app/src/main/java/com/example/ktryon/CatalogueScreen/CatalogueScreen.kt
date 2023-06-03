package com.example.ktryon.CatalogueScreen

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ktryon.CatalogueScreen.Controller.navigateFromCardToPreview
import com.example.ktryon.ui.theme.KtryonTheme
import com.example.ktryon.Client.requestShopItems
import com.example.ktryon.GlobalModel.ShopItem

// EXAMPLE
// val example_items: List<ShopItem> = List(16) {
//     if (it % 3 != 0) {
//         ShopItem(
//             "Femboy Skirt",
//             "$35.50",
//             "https://kawaiibabe.com/cdn/shop/products/princess-pink-plaid-fur-lined-skirt-xs-bottoms-cosplay-fairy-kei-kawaii-lolita-skirts-ddlg-playground-363_800x.jpg?v=1612736252",
//             listOf("Skirt", "Pink", "Ebullient", "Bubbly", "Oh")
//         )
//     } else {
//         ShopItem(
//             "Distinguished Tie",
//             "$12.50",
//             "https://i.kym-cdn.com/photos/images/newsfeed/002/343/546/d4f.jpg",
//             listOf("Gentleman", "Man", "Tie", "Handsome", "Emoji")
//         )
//     }
// }

var items: List<ShopItem> = listOf()

@Composable
fun CatalogueScreen(navController: NavHostController? = null) {
    Column {
        CatalogueHeader(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        )
        ShopItemGrid(navController = navController)
    }

    requestShopItems(context = LocalContext.current) {
        items = it
    }
}

@Composable
fun CatalogueHeader(modifier: Modifier = Modifier) {
//    Box(
//        modifier = modifier,
//        contentAlignment = Alignment.BottomStart
//    ) {
//        val darken = 0.6f
//        Image(
//            modifier = Modifier.fillMaxSize().blur(4.dp),
//            painter = painterResource(id = R.drawable.header_image),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//
//        )
//
//        Text(
//            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
//            text = "Try On",
//            style = MaterialTheme.typography.headlineLarge,
//            fontWeight = FontWeight.Bold
//        )
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