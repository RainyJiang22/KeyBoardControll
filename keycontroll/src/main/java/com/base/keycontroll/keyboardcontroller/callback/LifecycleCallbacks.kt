package com.base.keycontroll.keyboardcontroller.callback

import android.app.Application.ActivityLifecycleCallbacks
import androidx.core.view.WindowInsetsControllerCompat
import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.ViewCompat
import java.util.ArrayList

/**
 * Created by timeDoMain.
 * User: scy
 * Date: 2/26/21  8:34 PM
 */
class LifecycleCallbacks : ActivityLifecycleCallbacks {
    var decorView: View? = null
        private set
    var controller: WindowInsetsControllerCompat? = null
        private set
    private val activities: MutableList<Activity> = ArrayList()
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        activities.add(activity)
        decorView = activity.window.decorView
        controller = WindowCompat.getInsetsController(activity.window, decorView!!)
    }

    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    fun isVisible(type: Int): Boolean {
        return ViewCompat.getRootWindowInsets(decorView!!)!!.isVisible(type)
    }

    override fun onActivityDestroyed(activity: Activity) {
        activities.remove(activity)
        if (activities.size == 0) {
            decorView = null
            controller = null
        }
    }
}