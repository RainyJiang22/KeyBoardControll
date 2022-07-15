package com.base.keycontroll

import androidx.core.view.WindowInsetsCompat

/**
 * @author jiangshiyu
 * @date 2022/7/15
 */
object UIType {
    val KEYBOARD = WindowInsetsCompat.Type.ime()
    val ALL_BARS = WindowInsetsCompat.Type.systemBars()
    val STATUS_BAR = WindowInsetsCompat.Type.statusBars()
    val NAVIGATION_BAR = WindowInsetsCompat.Type.navigationBars()

}