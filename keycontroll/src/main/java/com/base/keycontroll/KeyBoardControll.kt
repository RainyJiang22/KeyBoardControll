package com.base.keycontroll

import android.app.Application
import android.view.View
import android.widget.EditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsAnimationCompat
import com.base.keycontroll.callback.LifecycleCallbacks
import com.base.keycontroll.callback.RootViewDeferringInsetsCallback
import com.base.keycontroll.callback.ViewAutoMoveCallback
import com.base.keycontroll.listener.KeyBoardListener

/**
 * @author jiangshiyu
 * @date 2022/7/15
 */
class KeyBoardControll private constructor() {
    private var lifecycleCallbacks: LifecycleCallbacks? = null
    fun register(application: Application) {
        lifecycleCallbacks = LifecycleCallbacks()
        application.registerActivityLifecycleCallbacks(lifecycleCallbacks)
    }

    fun setKeyBoardListener(keyBoardListener: KeyBoardListener) {
        val rootViewInsetsCallback = RootViewDeferringInsetsCallback(
            WindowInsetsAnimationCompat.Callback.DISPATCH_MODE_CONTINUE_ON_SUBTREE,
            keyBoardListener
        )
        lifecycleCallbacks?.getDecorView()?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it, rootViewInsetsCallback)
        }
        lifecycleCallbacks?.getDecorView()?.let {
            ViewCompat.setWindowInsetsAnimationCallback(it, rootViewInsetsCallback)
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
        lifecycleCallbacks?.let {
            val visible: Boolean = it.isVisible(UIType.KEYBOARD)
            if (visible) {
                it.getController()?.hide(UIType.KEYBOARD)
            } else {
                editText.requestFocus()
                it.getController()?.show(UIType.KEYBOARD)
            }
        }


    }

    companion object {

        //singleton
        @Volatile
        private var instance: KeyBoardControll? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: KeyBoardControll().also { instance = it }
            }
    }
}