package com.example.ktryon.PreviewScreen.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ktryon.Components.SegmentedButton
import com.example.ktryon.PreviewScreen.Model.ShopItem

@Composable
fun TitleAndSize(shopItem: ShopItem, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PreviewTitle(text = shopItem.name)
            PreviewPrice(shopItem.price)
        }


        Spacer(Modifier.width(0.dp))

        val sizes = listOf("S", "M", "L")


        // curse you compose devs
        SegmentedButton(
            items = sizes,
            itemWidth = 54.dp,
            itemHeight = 32.dp,

            outlineColor = MaterialTheme.colorScheme.outline,
            selectedColor = MaterialTheme.colorScheme.secondaryContainer,
            unselectedColor = MaterialTheme.colorScheme.surface,
        ) { item, isSelected ->
            Text(
                text = item,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.onSecondaryContainer
                } else {
                    MaterialTheme.colorScheme.onSurface
                },
            )
        }
    }
}

@Composable
private fun PreviewTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun PreviewPrice(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}