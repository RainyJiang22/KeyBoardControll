package com.base.keyboardcontroll

import android.app.Application
import com.base.keycontroll.KeyBoardControll

/**
 * @author jiangshiyu
 * @date 2022/7/15
 */
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        KeyBoardControll.getInstance().register(this)
    }
}