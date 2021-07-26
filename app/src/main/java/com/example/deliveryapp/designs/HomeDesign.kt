package com.example.deliveryapp.designs

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.deliveryapp.models.ResultsItem
import com.example.deliveryapp.utils.PAGE_SIZE
import com.example.deliveryapp.utils.TAG
import com.example.deliveryapp.viewmodels.HomeActivityViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TextFieldDesign(
    modifier: Modifier = Modifier,
    onClick: (text: String, scrollPosition: Int) -> Unit
) {

    var queryState by remember {
        mutableStateOf("")
    }

    Row(modifier = modifier, verticalAlignment = Alignment.Bottom) {

        OutlinedTextField(
            value = queryState,
            singleLine = true,
            label = {
                Text(text = "Search")
            },
            onValueChange = { newText ->
                queryState = newText
            },
            modifier = Modifier
                .weight(7f)
                .padding(horizontal = 10.dp)
                .height(60.dp),
            textStyle = TextStyle(fontSize = 18.sp)
        )

        OutlinedButton(
            onClick = {
                onClick(queryState, 0)
            },
            modifier = Modifier
                .weight(3f)
                .padding(end = 10.dp)
                .height(52.dp)
                .clip(RoundedCornerShape(5.dp)),
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            border = BorderStroke(1.dp, Color.Blue)
        ) {

            Text(
                text = "Search",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

        }

    }

}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun FoodList(
    modifier: Modifier = Modifier,
    recipes: List<ResultsItem?>?,
    viewModelProvider: HomeActivityViewModel,
    page: Int
) {

    val listState = rememberLazyListState()

    // remember a CoroutineScope to be able to launch
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(modifier = modifier, state = listState) {

        itemsIndexed(items = recipes!!) { index, item ->

            viewModelProvider.onChangeScrollPosition(index)

            /**
             * pagination statement
             */
            if ((index + 1) >= (page * PAGE_SIZE)) {

                viewModelProvider.nextRecipePage()

            }
            RecipeCard(recipe = item, modifier = Modifier.padding(vertical = 10.dp))

        }

    }

    if (viewModelProvider.scrollPositionInSearch.value){
        coroutineScope.launch {
            listState.animateScrollToItem(0)
        }
    }

}

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: ResultsItem?
) {

    Card(
        modifier = modifier,
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
                    contentScale = ContentScale.Companion.Crop,
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