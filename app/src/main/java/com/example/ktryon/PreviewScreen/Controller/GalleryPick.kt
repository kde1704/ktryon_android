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
    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }

    val bitmap =  remember {
        mutableStateOf<Bitmap?>(null)
    }

    val pickImageLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            imageUri.value = uri
        }
    }

    imageUri.value?.let {
        val source = ImageDecoder
            .createSource(LocalContext.current.contentResolver, it)
        bitmap.value = ImageDecoder.decodeBitmap(source)

        bitmap.value?.let { btm ->
            after(btm)
        }
    }

    return pickImageLauncher
}
