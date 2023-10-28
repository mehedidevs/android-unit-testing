package com.mehedi.myappunittest.quotes


import androidx.annotation.Keep

@Keep
data class Quote(
    var author: String? = null,
    var text: String? = null
)