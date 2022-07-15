package com.base.keycontroll.keyboardcontroller

import androidx.core.view.WindowInsetsCompat

/**
 * Created by timeDoMain.
 * User: scy
 * Date: 2/26/21  8:07 PM
 */
object UiType {
    @JvmField
    val KEYBOARD = WindowInsetsCompat.Type.ime()
    val ALL_BARS = WindowInsetsCompat.Type.systemBars()
    val STATUS_BAR = WindowInsetsCompat.Type.statusBars()
    val NAVIGATION_BAR = WindowInsetsCompat.Type.navigationBars()
}