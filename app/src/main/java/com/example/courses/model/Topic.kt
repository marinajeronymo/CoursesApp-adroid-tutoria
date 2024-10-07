package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameId: Int,
    val availableCoursesId: Int,
    @DrawableRes val imageId: Int
)
