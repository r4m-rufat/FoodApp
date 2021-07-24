package com.example.deliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryapp.models.ResultsItem
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import com.example.deliveryapp.viewmodels.HomeActivityViewModel

class HomeActivity : ComponentActivity() {

    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var viewModelProvider = ViewModelProvider(this).get(HomeActivityViewModel::class.java)

//        viewModelProvider.getDeliveryList().observe(this, object : Observer<List<ResultsItem?>?>{
//            override fun onChanged(t: List<ResultsItem?>?) {
//                Log.d(TAG, "onChanged: Comes --> ${t?.get(0)?.title} ")
//                deliveryList = t
//
//            }
//
//        })

        setContent {
            DeliveryAppTheme {

                val deliveryList = viewModelProvider.deliveryList.value

                deliveryList?.let {
                    if (it != null){
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

        for (recipe in recipes!!){
            Text(text = recipe!!.title.toString())
        }

    }

}