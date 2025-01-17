package com.tech.maxclub.alligatorvscrocodileclassifier.feature.classification.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tech.maxclub.alligatorvscrocodileclassifier.R
import com.tech.maxclub.alligatorvscrocodileclassifier.feature.classification.domain.ClassificationResult

@Composable
fun ClassificationResultComponent(
    result: ClassificationResult,
    onReadForDetails: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = result.label),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
                TextButton(
                    onClick = { onReadForDetails(context.getString(result.details)) },
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = stringResource(R.string.read_for_details_button))
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = (result.score * 100).toInt().toString(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                )
                CircularProgressIndicator(
                    progress = result.score,
                    strokeWidth = 6.dp,
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier.size(64.dp)
                )
            }
        }
    }
}