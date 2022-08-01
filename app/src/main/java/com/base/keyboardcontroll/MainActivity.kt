package com.base.keyboardcontroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.WindowCompat
import com.base.keyboardcontroller.listener.KeyboardListener
import com.base.keycontroll.KeyBoardControll
import com.base.keycontroll.keyboardcontroller.SystemUiControll
import com.base.keycontroll.listener.KeyBoardListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SystemUiControll.instance.showOrHideKeyBoard(edt)
        SystemUiControll.instance.showOrHideKeyBoard(edt)
        SystemUiControll.instance.setKeyBoardListener(object : KeyboardListener {
            override fun onKeyBoardAnimStart() {
                Log.d("KeyBoard", "onKeyBoardAnimStart: ")
            }

            override fun onKeyBoardHeightChange(height: Int) {

                Log.d("KeyBoard", "onKeyBoardHeightChange: $height")
                btn_height?.apply {
                    text = "height:$height"
                }
            }

            override fun onKeyBoardAnimEnd() {

            }

        })
    }
}