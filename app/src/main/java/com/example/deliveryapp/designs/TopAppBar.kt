package com.example.deliveryapp.designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.R

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    icon: Painter,
    isMenuOn: Boolean
) {

    TopAppBar(
        modifier = modifier,
        backgroundColor = Color(0xFFFFBF00),
    ) {

        Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {

            Row(
                verticalAlignment = Alignment.CenterVertically
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
                    fontSize = 22.sp,
                    color = Color.White,
                    fontFamily = FontFamily.Serif
                )

            }

            if (isMenuOn){
                Row {

                    Icon(
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 10.dp
                            )
                            .size(35.dp),
                        painter = painterResource(id = R.drawable.ic_restaurant_menu),
                        contentDescription = null,
                        tint = Color.White,
                    )

                }
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewAppBar() {

    TopAppBar(
        title = "Zardab Foods",
        icon = painterResource(id = R.drawable.icon),
        isMenuOn = true
    )

}

