package com.example.ktryon.CatalogueScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ktryon.R
import com.example.ktryon.ShopItem.ShopItem
import com.example.ktryon.ui.theme.KtryonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopItemCard(modifier: Modifier = Modifier, shopItem: ShopItem) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(3.dp),
        onClick = {},
    ) {
        ShopItemImage(url = shopItem.imageUrl)
        ShopItemInfo(
            modifier = Modifier
                .padding(12.dp),
            name = shopItem.name,
            price = shopItem.price
        )
    }
}

@Composable
private fun ShopItemImage(modifier: Modifier = Modifier, url: String) {
    val async_painter = rememberAsyncImagePainter(
        model =
        ImageRequest.Builder(LocalContext.current)
            .data(url)
            .size(coil.size.Size.ORIGINAL)
            .crossfade(true)
            .build()
    )

    val painter = if (async_painter.state is AsyncImagePainter.State.Success) {
        async_painter
    } else {
        painterResource(id = R.drawable.placeholder)
    }

    Image(
        modifier = modifier,
        contentScale = ContentScale.FillWidth,
        painter = painter,
        contentDescription = null
    )
}

@Composable
private fun ShopItemInfo(modifier: Modifier = Modifier, name: String, price: String) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = price,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
        )
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ShopItemCardPreview() {
    KtryonTheme {
        ShopItemCard(
            modifier =
            Modifier.width(200.dp),
            shopItem =
            ShopItem(
                "Femboy Skirt",
                "$35.50",
                "https://kawaiibabe.com/cdn/shop/products/princess-pink-plaid-fur-lined-skirt-xs-bottoms-cosplay-fairy-kei-kawaii-lolita-skirts-ddlg-playground-363_800x.jpg?v=1612736252"
            )
        )
    }
}