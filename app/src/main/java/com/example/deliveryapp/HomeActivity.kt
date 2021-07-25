package com.example.deliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import coil.compose.rememberImagePainter
import com.example.deliveryapp.designs.FoodList
import com.example.deliveryapp.designs.TextFieldDesign
import com.example.deliveryapp.models.ResultsItem
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import com.example.deliveryapp.viewmodels.HomeActivityViewModel

class HomeActivity : ComponentActivity() {

    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var viewModelProvider = ViewModelProvider(this).get(HomeActivityViewModel::class.java)

        setContent {
            DeliveryAppTheme {

                Column(modifier = Modifier.fillMaxSize()) {

                    TextFieldDesign()

                    Spacer(modifier = Modifier.height(10.dp))

                    val deliveryList = viewModelProvider.deliveryList.value

                    val page = viewModelProvider.page.value

                    deliveryList?.let {recipes ->

                        FoodList(recipes = recipes, modifier = Modifier.padding(horizontal = 10.dp), page = page, viewModelProvider = viewModelProvider)

                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    Column(modifier = Modifier.fillMaxSize()) {
        TextFieldDesign(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )

    }
}

@Composable
fun TextTest(
    recipes: List<ResultsItem?>?
) {

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        for (recipe in recipes!!) {
            Text(text = recipe!!.title.toString())
            Image(
                painter = rememberImagePainter(data = recipe!!.image.toString()),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }

    }

}

