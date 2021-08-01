package com.example.deliveryapp.designs

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun RecommendedFoodsWord() {

    Text(text = buildAnnotatedString {

        withStyle(
            style = SpanStyle(
                color = Color(0xFF33C000),
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                fontSize = 24.sp
            )
        ) {

            append("R")
        }

        append("ecommended  ")

        withStyle(
            style = SpanStyle(
                color = Color(0xFF33C000),
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                fontSize = 24.sp
            )
        ) {

            append("F")
        }

        append("oods")

    },
    fontSize = 18.sp,
    color = Color.Black,
    fontWeight = FontWeight.Bold,
    letterSpacing = 1.sp)

}