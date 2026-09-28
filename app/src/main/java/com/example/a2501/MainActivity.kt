package com.example.a2501

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a2501.ui.theme.AnalyticsTracker
import com.example.a2501.ui.theme._2501Theme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val audioPlayer = AudioPlayer()
        val analyticsTracker = AnalyticsTracker()
        lifecycle.addObserver(audioPlayer)
        lifecycle.addObserver(analyticsTracker)

        UserTracker.register(this)
        Timber.d("Зареєстровано слухачів у UserTracker: ${UserTracker.getListenersCount()}")

        setContent {
            _2501Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Greeting(name = "Android")

                        Button(
                            onClick = {
                                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text("Перейти на SecondActivity")
                        }
                    }
                }
            }
        }
    }

    // Фінальний варіант виправлення витоку (спосіб B): Activity видаляє себе
    // зі списку слухачів, коли знищується.
    override fun onDestroy() {
        UserTracker.unregister(this)
        super.onDestroy()
    }

    // Попередня ручна реєстрація детектора з Частин 1-4:
    // override fun onStart() {
    //     super.onStart()
    //     val detector = (application as MyApplication).backgroundDetector
    //     detector.onActivityStarted()
    // }
    //
    // override fun onStop() {
    //     super.onStop()
    //     val detector = (application as MyApplication).backgroundDetector
    //     detector.onActivityStopped()
    // }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _2501Theme {
        Greeting("Android")
    }
}
