package com.hoonsa.mywidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoonsa.my_button.MyToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyToast.sToast(this, "하하하")
    }
}