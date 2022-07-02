package com.hoonsa.my_button

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.*
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.shapes.RoundRectShape
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.hoonsa.my_button.extension.initBorder
import com.hoonsa.my_button.extension.initCorner
import com.hoonsa.my_button.extension.initGradient


class MyButton @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
): AppCompatButton(context, attributeSet) {
    companion object{
        const val TAG = "MyButton"

        const val XML_DEFAULT = -999999
    }

    init {
        val typed = context.obtainStyledAttributes(attributeSet, R.styleable.MyButton, defStyleAttr, defStyleRes)

        try {
            background = GradientDrawable()
                .initGradient(typed)
                .initCorner(typed)
                .initBorder(typed)

        }finally {
            typed.recycle()
        }
    }
}
