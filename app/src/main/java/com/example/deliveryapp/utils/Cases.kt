package com.example.deliveryapp.utils

/**
 * check minute value greater than 1 or not
 * then set "minute" or "minutes"
 */
fun checkMinuteTextSinPul(minute: Int): String{

    return when(minute){

        1 -> "$minute minute"
        else -> "$minute minutes"

    }

}