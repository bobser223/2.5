package com.example.a2501

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import timber.log.Timber

class MyApplication : Application() {

    val backgroundDetector = BackgroundDetector()

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        ProcessLifecycleOwner.get().lifecycle.addObserver(backgroundDetector)

        // Попередня реєстрація з Частини 5:
        // registerActivityLifecycleCallbacks(backgroundDetector)

        registerActivityLifecycleCallbacks(
            object : ActivityLifecycleCallbacks {

                override fun onActivityCreated(
                    activity: Activity,
                    savedInstanceState: Bundle?
                ) {
                    Timber.d(
                        "onActivityCreated | " +
                                "Activity: ${activity.javaClass.simpleName} | " +
                                "State: ${(activity as LifecycleOwner).lifecycle.currentState}"
                    )
                }

                override fun onActivityStarted(activity: Activity) {
                    Timber.d(
                        "onActivityStarted | " +
                                "Activity: ${activity.javaClass.simpleName} | " +
                                "State: ${(activity as LifecycleOwner).lifecycle.currentState}"
                    )
                }

                override fun onActivityResumed(activity: Activity) {
                    Timber.d(
                        "onActivityResumed | " +
                                "Activity: ${activity.javaClass.simpleName} | " +
                                "State: ${(activity as LifecycleOwner).lifecycle.currentState}"
                    )
                }

                override fun onActivityPaused(activity: Activity) {
                    Timber.d(
                        "onActivityPaused | " +
                                "Activity: ${activity.javaClass.simpleName} | " +
                                "State: ${(activity as LifecycleOwner).lifecycle.currentState}"
                    )
                }

                override fun onActivityStopped(activity: Activity) {
                    Timber.d(
                        "onActivityStopped | " +
                                "Activity: ${activity.javaClass.simpleName} | " +
                                "State: ${(activity as LifecycleOwner).lifecycle.currentState}"
                    )
                }

                override fun onActivitySaveInstanceState(
                    activity: Activity,
                    outState: Bundle
                ) {
                    Timber.d(
                        "onActivitySaveInstanceState | " +
                                "Activity: ${activity.javaClass.simpleName} | " +
                                "State: ${(activity as LifecycleOwner).lifecycle.currentState}"
                    )
                }

                override fun onActivityDestroyed(activity: Activity) {
                    Timber.d(
                        "onActivityDestroyed | " +
                                "Activity: ${activity.javaClass.simpleName} | " +
                                "State: ${(activity as LifecycleOwner).lifecycle.currentState}"
                    )
                }
            }
        )
    }
}
