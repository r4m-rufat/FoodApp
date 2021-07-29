package com.example.deliveryapp.utils.convertors

import org.jsoup.Jsoup

fun convertHTMLToString(html: String): String{

    return Jsoup.parse(html).text()

}