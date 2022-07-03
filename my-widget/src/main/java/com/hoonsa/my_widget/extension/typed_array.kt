package com.hoonsa.my_widget.extension

import android.content.res.TypedArray
import androidx.annotation.StyleableRes
import androidx.core.content.res.getColorOrThrow

internal fun TypedArray.getColorOrNull(@StyleableRes res: Int): Int? {
    return try {
        this.getColorOrThrow(res)
    }catch (e: Exception){
        null
    }
}
