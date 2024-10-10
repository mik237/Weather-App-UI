package me.ibrahim.weather_app_ui.weather_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.ibrahim.weather_app_ui.R

@Composable
fun WeatherDetail() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 15.dp, vertical = 8.dp)
            .background(
                color = Color(0xff331866),
                shape = RoundedCornerShape(20)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 15.dp)
        ) {
            WeatherDetailItem(R.drawable.rain, "22%", "Rain")
            WeatherDetailItem(R.drawable.wind, "12km/h", "Wind Speed")
            WeatherDetailItem(R.drawable.humidity, "18%", "Humidity")
        }
    }
}