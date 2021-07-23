package com.example.deliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.deliveryapp.apis.ApiClient
import com.example.deliveryapp.apis.IApi
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import com.example.deliveryapp.viewmodels.HomeActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var viewModelProvider = ViewModelProvider(this).get(HomeActivityViewModel::class.java)

        CoroutineScope(IO).launch {
            viewModelProvider.init()
            viewModelProvider.getDeliveryList()
        }

        setContent {
            DeliveryAppTheme {



            }
        }
    }
}

@Composable
fun Greeting(name: String) {



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}