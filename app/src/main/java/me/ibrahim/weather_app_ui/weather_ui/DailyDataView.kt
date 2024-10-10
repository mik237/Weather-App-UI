package me.ibrahim.weather_app_ui.weather_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.weather_app_ui.R


@Composable
fun DailyDataView(dailyData: DailyData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = dailyData.day,
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.padding(end = 20.dp)
        )

        Image(
            painter = painterResource(id = getDrawableResourceId(dailyData.picPath)),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 20.dp)
                .size(30.dp)
        )

        Text(
            text = dailyData.status,
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
        )

        Text(
            text = "${dailyData.highTemp}\u00B0",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.padding(end = 20.dp)
        )

        Text(
            text = "${dailyData.lowTemp}\u00B0",
            fontSize = 15.sp,
            color = Color.White
        )
    }
}

fun getDrawableResourceId(picPath: String): Int {
    return when (picPath) {
        "storm" -> R.drawable.storm
        "cloudy" -> R.drawable.cloudy
        "windy" -> R.drawable.windy
        "cloudy_sunny" -> R.drawable.cloudy_sunny
        "sunny" -> R.drawable.sunny
        "rainy" -> R.drawable.rainy
        else -> R.drawable.cloudy
    }
}


val dailyDataItems = listOf(
    DailyData("Sat", "storm", "Storm", 24, 12),
    DailyData("Sun", "cloudy", "Cloudy", 24, 10),
    DailyData("Mon", "windy", "Windy", 25, 16),
    DailyData("Tue", "cloudy_sunny", "Cloudy Sunny", 29, 15),
    DailyData("Wed", "sunny", "Sunny", 28, 13),
    DailyData("Thu", "rainy", "Rainy", 28, 11),
    DailyData("Fri", "storm", "Storm", 23, 12),
)

data class DailyData(
    val day: String,
    val picPath: String,
    val status: String,
    val highTemp: Int,
    val lowTemp: Int
)