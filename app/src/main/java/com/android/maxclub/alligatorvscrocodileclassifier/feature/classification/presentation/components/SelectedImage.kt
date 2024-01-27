package com.android.maxclub.alligatorvscrocodileclassifier.feature.classification.presentation.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.maxclub.alligatorvscrocodileclassifier.R

@Composable
fun SelectedImage(
    imageUrl: String,
    onSuccess: (String, Drawable) -> Unit,
    onError: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = stringResource(R.string.selected_image),
        contentScale = ContentScale.Fit,
        onSuccess = {
            onSuccess(imageUrl, it.result.drawable)
        },
        onError = {
            onError(imageUrl)
        },
        modifier = modifier.clip(RoundedCornerShape(16.dp))
    )
}