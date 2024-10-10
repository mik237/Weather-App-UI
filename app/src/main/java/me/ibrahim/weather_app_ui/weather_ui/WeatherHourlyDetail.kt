package me.ibrahim.weather_app_ui.weather_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.weather_app_ui.R


@Composable
fun WeatherHourlyDetail() {
    Text(
        text = "Today",
        fontSize = 16.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 15.dp, top = 8.dp)
            .fillMaxWidth()
    )

    LazyRow(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        items(hourlyDataItems, key = {
            "${it.hour}-${it.temp}-${it.picPath}"
        }) {
            HourlyDataView(hourlyData = it)
        }
    }
}

@Composable
fun HourlyDataView(hourlyData: HourlyData) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(150.dp)
            .padding(5.dp)
            .background(
                Color(0xff331866),
                shape = RoundedCornerShape(12.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = hourlyData.hour,
            fontSize = 16.sp,
            color = Color.White
        )

        Image(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .size(40.dp),
            painter = painterResource(
                id =
                when (hourlyData.picPath) {
                    "cloudy" -> R.drawable.cloudy
                    "sunny" -> R.drawable.sunny
                    "wind" -> R.drawable.wind
                    "rainy" -> R.drawable.rainy
                    "storm" -> R.drawable.storm
                    else -> R.drawable.cloudy
                }
            ), contentDescription = null
        )

        Text(
            text = "${hourlyData.temp}\u00B0",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

val hourlyDataItems = listOf(
    HourlyData(hour = "9 pm", temp = 28, "cloudy"),
    HourlyData(hour = "10 pm", temp = 29, "sunny"),
    HourlyData(hour = "11 pm", temp = 30, "wind"),
    HourlyData(hour = "12 pm", temp = 31, "rainy"),
    HourlyData(hour = "1 am", temp = 28, "storm"),
)

data class HourlyData(
    val hour: String,
    val temp: Int,
    val picPath: String
)