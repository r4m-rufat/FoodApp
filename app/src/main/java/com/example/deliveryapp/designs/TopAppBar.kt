package com.example.deliveryapp.designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.R

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    icon: Painter
) {

    TopAppBar(
        modifier = modifier,
        backgroundColor = Color(0xFFFFBF00)
    ) {
        Image(
            modifier = Modifier.padding(
                start = 8.dp,
                end = 10.dp
            ),
            painter = icon,
            contentDescription = null
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewAppBar() {

    TopAppBar(title = "Zardab Foods", icon = painterResource(id = R.drawable.icon))

}

