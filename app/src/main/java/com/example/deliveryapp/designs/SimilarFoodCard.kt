package com.example.deliveryapp.designs

import android.widget.RatingBar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.R

@Composable
fun SimilarFoodCard() {

    Card(
        modifier = Modifier
            .padding(end = 20.dp)
            .width(150.dp)
            .height(200.dp)
            .background(Color.White),
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.5.dp, Color(0xFFE7C100))
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
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
                color = Color.Black,
                modifier = Modifier.padding(
                    horizontal = 8.dp,
                    vertical = 5.dp
                )
            )


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

            Column(modifier = Modifier.fillMaxWidth()) {
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
                    color = Color.Black,
                    modifier = Modifier.padding(
                        horizontal = 8.dp,
                        vertical = 5.dp
                    )
                )

            }

        }

    }

}