package com.example.deliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.rememberImagePainter
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

                val deliveryList = viewModelProvider.deliveryList.value

                deliveryList?.let {
                    if (it != null) {
                        TextTest(recipes = it)
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}

@Composable
fun TextTest(
    recipes: List<ResultsItem?>?
) {

    Column(modifier = Modifier.fillMaxWidth()) {

        for (recipe in recipes!!) {
            Text(text = recipe!!.title.toString(), modifier = Modifier.padding(10.dp))
            Image(
                painter = rememberImagePainter(data = recipe!!.image.toString()),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }

    }

}