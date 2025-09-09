package com.example.firstcomposeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.firstcomposeapp.R

val robotoFlex = FontFamily(
    Font(R.font.roboto_flex, weight = FontWeight.Normal),
    Font(R.font.roboto_flex, weight = FontWeight.Medium)
)

val CustomTypography = Typography(
    headlineLarge = TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontFamily = robotoFlex,
        fontWeight = FontWeight.Medium
    ),
    titleMedium = TextStyle(
        fontSize = 28.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontFamily = robotoFlex,
        fontWeight = FontWeight.Medium
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        fontFamily = robotoFlex,
        fontWeight = FontWeight.Normal,
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        fontFamily = robotoFlex,
        fontWeight = FontWeight.Medium,
    ),
    labelSmall = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontFamily = robotoFlex,
        fontWeight = FontWeight.Medium,
    )
)