package be.odisee.diceroller

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LifecycleTracker(val screen: String): DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(screen, "onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        Log.d(screen, "onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(screen, "onResume")

    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(screen,"onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(screen,"onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(screen,"onDestroy")
    }
}