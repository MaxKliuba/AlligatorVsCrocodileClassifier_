package com.android.maxclub.alligatorvscrocodileclassifier.feature.classification.domain

import androidx.annotation.StringRes
import com.android.maxclub.alligatorvscrocodileclassifier.R

sealed class ClassificationResult(
    val score: Float,
    @StringRes val label: Int,
    @StringRes val details: Int,
) {
    class Alligator(score: Float) :
        ClassificationResult(score, R.string.alligator_label, R.string.alligator_details)

    class Crocodile(score: Float) :
        ClassificationResult(score, R.string.crocodile_label, R.string.crocodile_details)

    class Unknown(score: Float) :
        ClassificationResult(score, R.string.unknown_label, R.string.unknown_details)
}
