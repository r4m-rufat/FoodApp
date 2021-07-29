package com.example.deliveryapp.designs

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.deliveryapp.R

@Composable
fun RecipeDetail(
    modifier: Modifier = Modifier,
    foodImage: String? = null,
    foodTitle: String? = null,
    foodDescription: String? = null
) {

    val scrollState = rememberScrollState()

    Column(modifier = modifier
        .padding(10.dp)
        .verticalScroll(scrollState)) {

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

                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                        )
                        .border(2.dp, Color(0xFFF8C00))
                        .padding(horizontal = 30.dp, vertical = 6.dp),
                    text = foodTitle!!,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 20.sp,
                )


            }

        }

        Text(
            text = "Receipt",
            modifier = Modifier.padding(top = 24.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = foodDescription!!,
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 14.sp,
            color = Color.Black,
            lineHeight = 20.sp
        )


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

        RecipeDetail(foodTitle = "95", foodDescription = "The recipe Homemade Garlic and Basil French Fries is ready <b>in roughly 45 minutes</b> and is definitely a super <b>vegan</b> option for lovers of American food. One serving contains <b>596 calories</b>, <b>18g of protein</b>, and <b>15g of fat</b>. For <b>83 cents per serving</b>, you get a side dish that serves 2. Several people made this recipe, and 1669 would say it hit the spot. If you have garlic salt, flour, garlic powder, and a few other ingredients on hand, you can make it. All things considered, we decided this recipe <b>deserves a spoonacular score of 100%</b>. This score is outstanding. Try <a href=\\\"https://spoonacular.com/recipes/homemade-french-fries-with-fresh-garlic-and-dill-494220\\\">Homemade French Fries with Fresh Garlic and Dill</a>, <a href=\\\"https://spoonacular.com/recipes/roasted-garlic-french-fries-519898\\\">Roasted Garlic French Fries</a>, and <a href=\\\"https://spoonacular.com/recipes/sweet-potato-fries-with-basil-salt-and-garlic-mayonnaise-120735\\\">Sweet Potato Fries With Basil Salt and Garlic Mayonnaise</a> for similar recipes.", foodImage = "")

    }

}