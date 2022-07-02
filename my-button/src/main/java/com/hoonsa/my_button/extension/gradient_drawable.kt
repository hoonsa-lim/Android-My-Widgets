package com.hoonsa.my_button.extension

import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.InsetDrawable
import android.graphics.drawable.LayerDrawable
import android.util.Log
import com.hoonsa.my_button.MyButton
import com.hoonsa.my_button.R

internal fun GradientDrawable.initGradient(typed: TypedArray): GradientDrawable {
    val gradientColors = arrayListOf(
        typed.getColorOrNull(R.styleable.MyButton_gradientColorStart),
        typed.getColorOrNull(R.styleable.MyButton_gradientColorCenter),
        typed.getColorOrNull(R.styleable.MyButton_gradientColorEnd),
    ).filterNotNull().toIntArray()

    val orientation = typed.getInteger(R.styleable.MyButton_gradientOrientation, 0).let {
        GradientDrawable.Orientation.values()[it]
    }

    return this.apply {
        if (gradientColors.isNotEmpty() && gradientColors.size != 1) {
            this.colors = gradientColors
            this.orientation = orientation

        }else if(gradientColors.size == 1)
            Log.e(MyButton.TAG, "initGradientDrawable: required more than two gradient colors. color size == ${gradientColors.size}")
    }
}

internal fun GradientDrawable.initCorner(typed: TypedArray): GradientDrawable {
    val cornerRadius = typed.getDimension(R.styleable.MyButton_cornerRadius, MyButton.XML_DEFAULT.toFloat())
    Log.d(MyButton.TAG, "initCorner: cornerRadius == $cornerRadius")

    return this.apply {
        setCornerRadius(cornerRadius)
    }
}

internal fun GradientDrawable.initBorder(typed: TypedArray): Drawable {
    val bottomLayer = GradientDrawable()

    //color
    typed.getColorOrNull(R.styleable.MyButton_borderColor)?.let {
        bottomLayer.colors = intArrayOf(it, it)
    }

    //corner
    bottomLayer.initCorner(typed)

    //상위 레이어의 크기를 border width 만큼 축소
    val borderWidth = typed.getDimension(R.styleable.MyButton_borderWidth, 0f).toInt()
    val topLayer = InsetDrawable(this, borderWidth)

    return LayerDrawable(arrayOf(bottomLayer, topLayer))
}