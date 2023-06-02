package com.example.ktryon.PreviewScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ktryon.Components.SegmentedButton
import com.example.ktryon.PreviewScreen.Components.PreviewImage
import com.example.ktryon.PreviewScreen.Components.TitleAndSize
import com.example.ktryon.PreviewScreen.Model.ShopItem
import com.example.ktryon.R
import com.example.ktryon.ui.theme.KtryonTheme

@Composable
fun PreviewScreen(
    navController: NavHostController? = null,
    name: String,
    price: String,
    imageUrl: String
) {
    val shopItem = ShopItem(name, price, imageUrl)

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        ElevatedCard {
            PreviewImage(modifier = Modifier.fillMaxWidth(), url = shopItem.imageUrl)
        }

        TitleAndSize(modifier = Modifier.fillMaxWidth().padding(top = 32.dp), shopItem = shopItem)
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
                "https://kawaiibabe.com/cdn/shop/products/princess-pink-plaid-fur-lined-skirt-xs-bottoms-cosplay-fairy-kei-kawaii-lolita-skirts-ddlg-playground-363_800x.jpg?v=1612736252"
            )
        }
    }
}