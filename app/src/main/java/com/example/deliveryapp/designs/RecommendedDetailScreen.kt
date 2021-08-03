package com.example.deliveryapp.designs

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.deliveryapp.R
import com.example.deliveryapp.models.receipes.RecipeResponse
import com.example.deliveryapp.utils.checkMinuteTextSinPul
import com.example.deliveryapp.utils.convertors.convertHTMLToString

@Composable
fun RecommendedDetailScreen(
    modifier: Modifier = Modifier,
    recipe: RecipeResponse,
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Column(modifier = modifier
            .verticalScroll(scrollState)) {

            Card(
                modifier = Modifier.fillMaxWidth()
                    .border(BorderStroke(2.dp, Color(0xFFFBF00)))
                    .padding(top = 10.dp),
                elevation = 5.dp,
                shape = RoundedCornerShape(
                    topEnd = 10.dp,
                    topStart = 10.dp
                ),
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {

                    Image(
                        painter = rememberImagePainter(data = recipe.image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .scale(scaleX = 1.1f, scaleY = 1f),
                        contentScale = ContentScale.Crop
                    )
                }

            }

            Text(
                text = recipe.title!!,
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(
                        vertical = 10.dp,
                        horizontal = 30.dp
                    )
                    .fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )

            RecipeHealthTimeContainer(
                healthScore = "Score: ${recipe.healthScore}",
                readyTime = checkMinuteTextSinPul(recipe.readyInMinutes!!),
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Receipt",
                modifier = Modifier.padding(
                    top = 24.dp
                ),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )

            Text(
                text = convertHTMLToString(recipe.summary!!),
                modifier = Modifier.padding(
                    top = 10.dp,
                    bottom = 20.dp
                ),
                fontSize = 14.sp,
                color = Color.Black,
                lineHeight = 20.sp,
            )

        }

    }

}