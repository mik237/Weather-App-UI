package me.ibrahim.weather_app_ui.weather_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.weather_app_ui.R


@Preview(showBackground = true)
@Composable
fun WeatherScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xff59469d),
                        Color(0xff643d67)
                    )
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item { //display weather status
                Text(
                    text = stringResource(id = R.string.mostly_cloudy),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 56.dp, bottom = 10.dp)
                )
            }

            item { //display weather image
                Image(
                    painter = painterResource(id = R.drawable.cloudy_sunny),
                    contentDescription = null,
                    modifier = Modifier.size(140.dp)
                )
            }

            item { //display date & time
                Text(
                    text = "Mon June 17 | 10:00 AM",
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            item { //display temperature
                Text(
                    text = "25\u00B0",
                    fontSize = 65.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "H:27 L:18",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )

                WeatherDetail()
            }

            item {
                WeatherHourlyDetail()
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Future", color = Color.White)
                    Text(text = "Next 7 Days>", color = Color.White)
                }
            }
            items(dailyDataItems, key = {
                "${it.day}-${it.status}-${it.picPath}"
            }) {
                DailyDataView(dailyData = it)
            }
        }
    }
}


