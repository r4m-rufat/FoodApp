package com.example.deliveryapp.designs

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.deliveryapp.R
import com.example.deliveryapp.models.recommended_foods.ResultsItem

@Composable
fun RecipeDetail(
    modifier: Modifier = Modifier,
    foodImage: String? = null,
    foodTitle: String? = null,
    foodDescription: String? = null,
    readyTime: String? = null,
    healthScore: String? = null,
    list: List<ResultsItem?>,
    onCLickCard: (id: Int) -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 5.dp,
            shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp),
            border = BorderStroke(2.dp, Color(0xFFFBF00))
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.BottomEnd
            ) {

                Image(
                    painter = rememberImagePainter(data = foodImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(scaleX = 1.1f, scaleY = 1f),
                    contentScale = ContentScale.Crop
                )
            }

        }

        Text(
            text = foodTitle!!,
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            fontWeight = FontWeight.Bold
        )

        RecipeHealthTimeContainer(
            healthScore = healthScore!!,
            readyTime = readyTime!!,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Receipt",
            modifier = Modifier.padding(top = 24.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontStyle = FontStyle.Italic
        )

        Text(
            text = foodDescription!!,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
            fontSize = 14.sp,
            color = Color.Black,
            lineHeight = 20.sp,
            )

        RecommendedFoodsWord()

        Spacer(modifier = Modifier.height(12.dp))

        RecommendedFoodsList(modifier = Modifier.fillMaxWidth(), foodsList = list, onClickItem = { id ->
            onCLickCard(id)
        })

        Spacer(modifier = Modifier.height(20.dp))

    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .verticalScroll(scrollState)
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = 8.dp,
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .scale(scaleX = 1.1f, scaleY = 1f),
                        contentScale = ContentScale.Crop
                    )


                }

            }

            Text(
                text = "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
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
                        text = "5 minute",
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
                        text = "Score: 99",
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                }


            }

            Text(
                text = "Receipt",
                modifier = Modifier.padding(top = 24.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )

            Text(
                text = "",
                modifier = Modifier.padding(vertical = 10.dp),
                fontSize = 14.sp,
                color = Color.Black,
                lineHeight = 20.sp
            )


        }

    }

}