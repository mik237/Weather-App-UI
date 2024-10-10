package me.ibrahim.weather_app_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.ibrahim.weather_app_ui.ui.theme.WeatherAppUITheme
import me.ibrahim.weather_app_ui.weather_ui.WeatherScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppUITheme {
                WeatherScreen()
            }
        }
    }
}