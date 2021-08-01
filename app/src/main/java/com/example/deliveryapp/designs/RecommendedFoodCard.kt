package com.example.deliveryapp.designs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.deliveryapp.R
import com.example.deliveryapp.models.recommended_foods.ResultsItem

@Composable
fun RecommendedFoodCard(
    recommendedRecipes: ResultsItem?,
    rating: String,
    readyTime: String,
    onCLick: (id: Int) -> Unit
) {

    val colors = arrayOf(
        Color(0xFF17C5B1),
        Color(0xFF609756),
        Color(0xFF9C9045),
        Color(0xFFCC5032),
        Color(0xFF526CAF),
        Color(0xFF946BA3),
        Color(0xFFC54B56)
    )

    Card(
        modifier = Modifier
            .padding(end = 20.dp)
            .width(150.dp)
            .height(200.dp)
            .background(Color.White)
            .clickable(
                enabled = true,
                onClick = {
                    onCLick(recommendedRecipes?.id!!)
                }
            ),
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.5.dp, Color(0xFF00E7E7))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.random())
        ) {
            Image(
                painter = rememberImagePainter(data = recommendedRecipes?.image),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .scale(scaleX = 1.05f, scaleY = 1f),
                contentScale = ContentScale.Crop
            )

            recommendedRecipes?.title?.let {
                Text(
                    text = it,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(
                        top = 5.dp,
                        bottom = 0.dp,
                        end = 8.dp,
                        start = 8.dp
                    )
                )
            }

            Row(
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp
                    )
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null,
                        tint = Color(0xFFFFC600)
                    )

                    Text(
                        text = "$rating%",
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )

                }

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_timer),
                        contentDescription = null,
                        tint = Color(0xFFFFC600)
                    )

                    Text(
                        text = readyTime,
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )

                }

            }


        }

    }


}

@Preview(showBackground = true)
@Composable
fun Test() {

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Card(
            modifier = Modifier
                .padding(10.dp)
                .width(150.dp)
                .height(200.dp)
                .background(Color.White),
            elevation = 10.dp,
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp, Color.Gray)
        ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFC54B56))) {
                Image(
                    painter = painterResource(id = R.drawable.meal),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(
                        top = 5.dp,
                        bottom = 0.dp,
                        end = 8.dp,
                        start = 8.dp
                    )
                )

                Row(
                    modifier = Modifier
                        .padding(
                            horizontal = 8.dp
                        )
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            tint = Color(0xFFFFC600)
                        )

                        Text(
                            text = "90%",
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )

                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_timer),
                            contentDescription = null,
                            tint = Color(0xFFFFC600)
                        )

                        Text(
                            text = "45",
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )

                    }

                }

            }

        }

    }

}