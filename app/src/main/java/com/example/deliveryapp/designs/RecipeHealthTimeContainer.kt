package com.example.deliveryapp.designs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.R

@Composable
fun RecipeHealthTimeContainer(
    modifier: Modifier = Modifier,
    healthScore: String,
    readyTime: String
    ) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(id = R.drawable.ic_timer),
                contentDescription = null,
                tint = Color(0xFFFFDD00),
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = readyTime,
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )

        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(id = R.drawable.ic_health),
                contentDescription = null,
                tint = Color(0xFF2B9F02),
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = healthScore,
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )

        }

    }

}