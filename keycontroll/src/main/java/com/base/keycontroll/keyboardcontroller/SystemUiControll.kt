package com.base.keycontroll.keyboardcontroller

import android.app.Application
import android.view.View
import android.widget.EditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsAnimationCompat
import com.base.keyboardcontroller.callback.RootViewDeferringInsetsCallback
import com.base.keyboardcontroller.listener.KeyboardListener
import com.base.keycontroll.keyboardcontroller.callback.LifecycleCallbacks
import com.base.keycontroll.keyboardcontroller.callback.ViewAutoMoveCallback

/**
 * Created by timeDoMain.
 * User: scy
 * Date: 2/26/21  7:22 PM
 */
class SystemUiControll private constructor() {
    private var lifecycleCallbacks: LifecycleCallbacks? = null
    fun register(application: Application) {
        lifecycleCallbacks = LifecycleCallbacks()
        application.registerActivityLifecycleCallbacks(lifecycleCallbacks)
    }

    fun setKeyBoardListener(keyBoardListener: KeyboardListener?) {
        val rootViewInsetsCallback = RootViewDeferringInsetsCallback()
        rootViewInsetsCallback.keyboardListener = keyBoardListener
        lifecycleCallbacks?.decorView?.let {
            ViewCompat.setOnApplyWindowInsetsListener(
                it,
                rootViewInsetsCallback
            )
        }
        lifecycleCallbacks?.decorView?.let {
            ViewCompat.setWindowInsetsAnimationCallback(
                it,
                rootViewInsetsCallback
            )
        }
    }

    fun setAutoMoveView(vararg views: View?) {
        for (view in views) {
            setAutoMoveView(view)
        }
    }

    fun setAutoMoveView(view: View?) {
        val viewAutoMoveCallback =
            ViewAutoMoveCallback(WindowInsetsAnimationCompat.Callback.DISPATCH_MODE_STOP, view)
        ViewCompat.setWindowInsetsAnimationCallback(view!!, viewAutoMoveCallback)
    }

    fun showOrHideKeyBoard(editText: EditText) {
        val visible: Boolean = lifecycleCallbacks?.isVisible(UiType.KEYBOARD) ?: return
        if (visible) {
            lifecycleCallbacks?.controller?.hide(UiType.KEYBOARD)
        } else {
            editText.requestFocus()
            lifecycleCallbacks?.controller?.show(UiType.KEYBOARD)
        }
    }

    companion object {
        val instance = SystemUiControll()
    }
}