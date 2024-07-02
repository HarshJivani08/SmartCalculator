package com.app.smartcalculator.model

import android.content.Intent


data class SearchItem(
    var imageResource: Int = 0,
    var title: String = "",
    var intent: Intent?
)
