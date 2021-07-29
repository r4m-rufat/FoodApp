package com.example.deliveryapp.designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.deliveryapp.models.foods.ResultsItem

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: ResultsItem?,
    onClickCard: (index: Int) -> Unit
) {

    Card(
        modifier = modifier.clickable(
            enabled = true,
            onClick = {
                recipe?.id?.let { onClickCard(it) }
            }
        ),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {

            recipe?.image?.let { url ->
                Image(
                    painter = rememberImagePainter(data = url),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .scale(scaleX = 1.1f, scaleY = 1f)
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                )
            }

            recipe?.title?.let { title ->

                Text(
                    text = title,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp),
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                )

            }
        }
    }

}