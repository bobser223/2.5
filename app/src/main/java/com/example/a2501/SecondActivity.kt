package com.example.a2501

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import timber.log.Timber

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("SecondActivity: onCreate()")

        setContent {
            Text("Second Activity")
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.d("SecondActivity: onStart()")

        // val detector = (application as MyApplication).backgroundDetector
        // detector.onActivityStarted()
    }

    override fun onStop() {
        super.onStop()
        Timber.d("SecondActivity: onStop()")

        // val detector = (application as MyApplication).backgroundDetector
        // detector.onActivityStopped()
    }


    override fun onResume() {
        super.onResume()
        Timber.d("SecondActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("SecondActivity: onPause()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("SecondActivity: onDestroy()")
    }
}
