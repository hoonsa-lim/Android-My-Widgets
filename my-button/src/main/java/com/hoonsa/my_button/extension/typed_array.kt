package com.hoonsa.my_button.extension

import android.content.res.TypedArray
import androidx.annotation.StyleableRes
import androidx.core.content.res.getColorOrThrow

fun TypedArray.getColorOrNull(@StyleableRes res: Int): Int? {
    return try {
        this.getColorOrThrow(res)
    }catch (e: Exception){
        null
    }
}
