package com.supervital.powerweather.feature.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.supervital.powerweather.R
import com.supervital.powerweather.models.ForecastWeatherInfo
import kotlinx.coroutines.launch
import androidx.compose.material3.*
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import com.supervital.powerweather.models.ForecastItem

const val TAG = "WeatherMainScreen"
const val COLOR_BACKGROUND_LIST = 0x6397D3FF

@Composable
fun WeatherMainScreen(
    viewModel: MainViewModel,
    snackbarHostState: SnackbarHostState
) {
    val scope = rememberCoroutineScope()
    val uiState by viewModel.uiState.collectAsState()
    var isByDay by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    var data: ForecastWeatherInfo? = null

    when (uiState) {
        is UiState.Loading -> {
            ShowCircularProgress()
        }

        is UiState.Success -> {
            data = (uiState as UiState.Success).data
        }

        is UiState.Error -> {
            val sError = (uiState as UiState.Error).message
            Log.e(TAG, sError)
            LaunchedEffect(Unit) {
                snackbarHostState.showSnackbar(
                    message = sError,
                    duration = SnackbarDuration.Short
                )
            }
        }
    }
    Column(
        modifier = Modifier.height(1.dp)
    ) {
        Box(modifier = Modifier.height(260.dp)) {
            Image(
                painter = painterResource(R.drawable.weather_bg),
                contentDescription = "background",
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.5f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                            text = data?.getDateMain() ?: "",
                            style = TextStyle(fontSize = 15.sp),
                            color = Color.White
                        )
                        AsyncImage(
                            model = data?.getIconUrl(),
                            contentDescription = "im2",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(top = 3.dp, end = 8.dp)
                        )
                    }
                    Text(
                        text = data?.getCity() ?: "",
                        style = TextStyle(fontSize = 24.sp),
                        color = Color.White
                    )
                    Text(
                        text = data?.getCurrentTemperature() ?: "",
                        style = TextStyle(fontSize = 65.sp),
                        color = Color.White
                    )
                    Text(
                        text = data?.getConditionText() ?: "",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    viewModel.let {
                                        it.incIndexPlace()
                                        it.fetchData()
                                    }
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "im3",
                                tint = Color.White
                            )
                        }
                        Text(
                            text = data?.getTemperatureMaxMin() ?: "",
                            style = TextStyle(fontSize = 16.sp),
                            color = Color.White
                        )
                        IconButton(
                            onClick = {
                                scope.launch {
                                    viewModel.fetchData()
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_sync),
                                contentDescription = "im4",
                                tint = Color.White
                            )
                        }
                    }
                    ButtonsForecast(isByDay = isByDay) { isByDay = it }
                }
            }
        }
        LazyColumnScreen(data, isByDay)
    }
}

@Composable
fun LazyColumnScreen(data: ForecastWeatherInfo?, isByDay: Boolean) {
    val forecastList = if (isByDay) {
        data?.getForecastByHour() ?: emptyList()
    } else {
        data?.getForecastByDay() ?: emptyList()
    }
    Log.d(TAG, "forecast = $forecastList")
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items( items = forecastList) { forecast ->
            ItemForecast(forecastItem = forecast)
        }
    }
}

@Composable
fun ItemForecast(forecastItem: ForecastItem) {
    with(forecastItem) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(COLOR_BACKGROUND_LIST))
                .padding(16.dp)
        ){
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text(
                    fontSize = 20.sp,
                    text = getDateHour()
                )
                Text(
                    fontSize = 20.sp,
                    text = getConditionText()
                )
            }
            Text(
                modifier = Modifier
                    .weight(1f),
                fontSize = 20.sp,
                text = getTemperatureCommon())
            AsyncImage(
                model = getConditionIconUrl(),
                contentDescription = "imz",
                modifier = Modifier
                    .size(35.dp)
                    .padding(top = 3.dp, end = 8.dp)
                    .weight(1f)
            )
        }
    }
}

@Composable
fun ButtonsForecast(isByDay: Boolean, onSetForecastState: (Boolean) -> Unit) {
    Row {
        Button(
            modifier = Modifier
                .weight(1f)
                .drawBehind {
                    if (!isByDay)
                        return@drawBehind
                    val strokeWidth = 2f
                    val y = size.height
                    drawLine(
                        color = Color.White,
                        start = Offset(10f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = { onSetForecastState(true) }
        ) {
            Text(
                text = stringResource(R.string.by_hour),
                color = Color.White
            )
        }
        Button(
            modifier = Modifier
                .weight(1f)
                .drawBehind {
                    if (isByDay)
                        return@drawBehind
                    val strokeWidth = 2f
                    val y = size.height
                    drawLine(
                        color = Color.White,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = { onSetForecastState(false) }
        ) {
            Text(
                text = stringResource(R.string.by_day),
                color = Color.White
            )
        }
    }
}

@Composable
fun ShowCircularProgress() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        CircularProgressIndicator()
    }
}
