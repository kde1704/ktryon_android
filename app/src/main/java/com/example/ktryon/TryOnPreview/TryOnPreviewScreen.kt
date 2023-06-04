package com.example.ktryon.TryOnPreview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ktryon.Client.host
import com.example.ktryon.PreviewScreen.Components.PreviewImage

@Composable
fun TryOnPreviewScreen(
    uuid: String?
) {
    if (uuid == null) {
        return
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        ElevatedCard {
            PreviewImage(modifier = Modifier.fillMaxWidth(), url = "$host/viton/$uuid.png")
        }
    }
}