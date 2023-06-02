package com.example.ktryon.PreviewScreen.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ktryon.Components.InformationChip
import com.example.ktryon.Components.SimpleFlowRow

@Composable
fun Tags(tags: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Tags",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        SimpleFlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            verticalGap = 4.dp,
            horizontalGap = 8.dp,
        ) {
            for (tag in tags) {
                Tag(tag = tag)
            }
        }
    }
}

@Composable
private fun Tag(tag: String) {
    InformationChip() {
        Text(
            text = tag,
            style = MaterialTheme.typography.labelSmall
        )
    }
}
