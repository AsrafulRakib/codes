package com.bjit.driver.ui.screens.homescreen

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.imageLoader

@ExperimentalCoilApi
@Composable
fun CameraScreen() {
    var capturedImageUri by remember { mutableStateOf<Uri?>(null) } // Initialize with null instead of Uri.EMPTY
    val context = LocalContext.current

    val takePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageUri = result.data?.data ?: result.data?.extras?.getParcelable<Uri>(MediaStore.EXTRA_OUTPUT)
            capturedImageUri = imageUri
            Log.d("createImageUri", "createImageUri in compose: $capturedImageUri")
        }
    }

    Column {
        if (capturedImageUri != null) {
            val imageLoader = ImageLoader(context) // Create an ImageLoader instance
            val painter = rememberImagePainter(
                data = capturedImageUri,
                imageLoader = imageLoader, // Pass the imageLoader instance
                builder = {
                    // Resize the image to fit the Image composable
                    size(300, 300)
                    crossfade(true)
                }
            )

            Image(
                painter = painter,
                contentDescription = "Captured Image",
                modifier = Modifier
                    .size(300.dp)
                    .fillMaxWidth()
            )
        }

        Button(onClick = { openCamera(context, takePictureLauncher) }) {
            Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "Camera")
        }
    }
}

private fun openCamera(context: Context, launcher: ActivityResultLauncher<Intent>) {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    val photoUri: Uri? = createImageUri(context)

    if (photoUri != null) {
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
        launcher.launch(intent)
    }
}

private fun createImageUri(context: Context): Uri? {
    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, "photo.jpg")
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
    }
    val contentResolver = context.contentResolver
    Log.d("createImageUri", "createImageUri: ${contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)}")
    return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
}


@Preview
@Composable
fun CameraScreenPreview() {
    CameraScreen()
}
