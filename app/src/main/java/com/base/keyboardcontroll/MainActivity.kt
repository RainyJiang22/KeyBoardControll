package com.base.keyboardcontroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.base.keycontroll.KeyBoardControll
import com.base.keycontroll.listener.KeyBoardListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        KeyBoardControll.getInstance().showOrHideKeyBoard(et_add_color_text)
        KeyBoardControll.getInstance().setKeyBoardListener(object : KeyBoardListener {
            override fun onKeyBoardAnimStart() {
                Log.d("KeyBoard", "onKeyBoardAnimStart: ")
            }

            override fun onKeyBoardHeightChange(height: Int) {

                Log.d("KeyBoard", "onKeyBoardHeightChange: $height")
                fl_placeholder?.apply {
                    setPadding(paddingLeft, paddingTop, paddingRight, height)
                }
            }

            override fun onKeyBoardAnimEnd() {

            }

        })
    }
}