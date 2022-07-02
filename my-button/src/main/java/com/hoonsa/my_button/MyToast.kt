package com.hoonsa.my_button

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

class MyToast {
    companion object{
        fun sToast(context: Context, text: String) =
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

        fun sToast(context: Context, @StringRes stringRes: Int) =
            Toast.makeText(context, context.getString(stringRes), Toast.LENGTH_SHORT).show()
    }
}