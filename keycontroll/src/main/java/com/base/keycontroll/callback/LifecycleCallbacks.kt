package com.base.keycontroll.callback

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat


/**
 * @author jiangshiyu
 * @date 2022/7/15
 */
class LifecycleCallbacks : Application.ActivityLifecycleCallbacks {

    private var decorView: View? = null
    private var controller: WindowInsetsControllerCompat? = null


    fun getDecorView(): View? {
        return decorView
    }

    fun getController(): WindowInsetsControllerCompat? {
        return controller
    }

    private val activities = mutableListOf<Activity>()

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        activities.add(p0)
        decorView = p0.window.decorView
        controller = WindowCompat.getInsetsController(p0.window, decorView!!)
    }

    override fun onActivityStarted(p0: Activity) {
    }

    override fun onActivityResumed(p0: Activity) {
    }

    override fun onActivityPaused(p0: Activity) {
    }

    override fun onActivityStopped(p0: Activity) {
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
    }

    fun isVisible(type: Int): Boolean {
        return ViewCompat.getRootWindowInsets(decorView!!)!!.isVisible(type)
    }

    override fun onActivityDestroyed(p0: Activity) {
        activities.remove(p0)
        if (activities.size == 0) {
            decorView = null
            controller = null
        }
    }


}