package com.example.ktryon.PostCheckoutScreen

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ktryon.R
import com.example.ktryon.ui.theme.KtryonTheme

val mon =
    "49eVpZLA61UBWo4zRmn32HNWk9fEDSUEuBShEHuTyTEQUSwoSKb94XJ8wsKromdoNyHBqFVgLjUvWjoofXMmadheHjhifK9"

@Composable
fun PostCheckoutScreen(
    navController: NavHostController? = null,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(96.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Pay via Monero",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.height(32.dp))

            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.monero),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Spacer(Modifier.height(32.dp))

            val context = LocalContext.current
            Text(
                modifier = Modifier.clickable {
                    val clipboardManager: ClipboardManager =
                        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clipData = ClipData.newPlainText("address", mon)
                    clipboardManager.setPrimaryClip(clipData)
                },
                text = mon,
                style = MaterialTheme.typography.labelLarge
            )


        }

        Spacer(Modifier.weight(1f))

        Button(modifier = Modifier.fillMaxWidth().padding(24.dp), onClick = {
            navController?.navigate("Catalogue") {
                popUpTo(0)
            }
        }) {
            Text("Return", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CheckoutScreenPreview() {
    KtryonTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            PostCheckoutScreen(
                null,
           )
        }
    }
}