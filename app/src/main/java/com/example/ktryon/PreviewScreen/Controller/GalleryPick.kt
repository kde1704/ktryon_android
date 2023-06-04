package com.example.ktryon.PreviewScreen.Controller

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext

@Composable
fun chooseImageUriFromGallery(after: (Bitmap) -> Unit): ManagedActivityResultLauncher<String, Uri?> {
    val context = LocalContext.current
    val pickImageLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            val source = ImageDecoder
                .createSource(context.contentResolver, uri)
            
            val bitmap: Bitmap?
            bitmap = ImageDecoder.decodeBitmap(source)

            after(bitmap)
        }
    }


    return pickImageLauncher
}
