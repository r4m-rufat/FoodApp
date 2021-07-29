package com.example.deliveryapp.utils.convertors

import org.jsoup.Jsoup

/**
 * changes html codes to string
 */
fun convertHTMLToString(html: String): String{

    return Jsoup.parse(html).text()

}