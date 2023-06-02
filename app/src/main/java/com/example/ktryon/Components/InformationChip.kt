package com.example.ktryon.Components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ktryon.ui.theme.KtryonTheme

@Composable
fun InformationChip(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier =
        modifier
            //     .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline))
            .background(MaterialTheme.colorScheme.tertiaryContainer, RoundedCornerShape(100)),
        ) {

        Row(modifier = Modifier.padding(8.dp, 4.dp)) {
            content()
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ChipPreview() {
    KtryonTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            InformationChip {
                Text("Hello", maxLines = 1)
            }
        }
    }
}