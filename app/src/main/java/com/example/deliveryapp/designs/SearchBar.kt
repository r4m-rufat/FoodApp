package com.example.deliveryapp.designs

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.Cyan, RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(Color.Blue)
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

