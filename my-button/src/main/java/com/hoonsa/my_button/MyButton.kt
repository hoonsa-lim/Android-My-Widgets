package com.hoonsa.my_button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class MyButton @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
): AppCompatButton(context, attributeSet) {
    companion object{
        const val TAG = "MyButton"

        private const val XML_DEFAULT = -999999
    }

    init {
        val typed = context.obtainStyledAttributes(attributeSet, R.styleable.MyButton, defStyleAttr, defStyleRes)

        try {
            initGradient(typed)
            initCorner(typed)
        }finally {
            typed.recycle()
        }
    }

    private fun initCorner(typed: TypedArray) {
//        val cornerRadius = typed.getDimension(R.styleable.MyButton_cornerRadius, XML_DEFAULT.toFloat())
//        println("corner radius == $cornerRadius")
    }

    private fun initGradient(typed: TypedArray) {
        val gradientColors = intArrayOf(
            typed.getColor(R.styleable.MyButton_gradientColorStart, XML_DEFAULT),
            typed.getColor(R.styleable.MyButton_gradientColorCenter, XML_DEFAULT),
            typed.getColor(R.styleable.MyButton_gradientColorEnd, XML_DEFAULT)
        ).filterNot { it == XML_DEFAULT }.toIntArray()

        if (gradientColors.isEmpty()) return
        if (gradientColors.size == 1)                           //0개는 그라데이션 사용 x, 1개는 2개 이상 필요, 2개 이상은 정상 작동.
            throw AssertionError("required more than two gradient colors. color size == ${gradientColors.size}")

        val orientation = typed.getInteger(R.styleable.MyButton_gradientOrientation, 0).let {
            GradientDrawable.Orientation.values()[it]
        }

        val cornerRadius = typed.getDimension(R.styleable.MyButton_cornerRadius, XML_DEFAULT.toFloat())
        println("corner radius == $cornerRadius")

        this.background = GradientDrawable(orientation, gradientColors, ).apply {
            setCornerRadius(cornerRadius)
        }
    }
}