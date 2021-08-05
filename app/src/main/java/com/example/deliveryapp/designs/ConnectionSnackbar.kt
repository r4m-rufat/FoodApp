package com.example.deliveryapp.designs

import android.annotation.SuppressLint
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ConnectionSnackbar(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {


    scope.launch {
        scaffoldState.snackbarHostState.showSnackbar(
            message = "Network connection is lost",
            duration = SnackbarDuration.Indefinite,
            actionLabel = "Offline",
        )
    }


}