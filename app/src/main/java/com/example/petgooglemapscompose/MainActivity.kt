package com.example.petgooglemapscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petgooglemapscompose.ui.theme.PetGoogleMapsComposeTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

/*
Создать приложение с основным экраном в виде карты и следующими требованиями:
● Приложение должно находить устройство по геолокации.
● На карте можно ставить маркеры.
● На отдельном экране можно посмотреть и отредактировать список маркеров, добавить к маркеру название и аннотацию.
● Выбор архитектуры и библиотек остается за вами.
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetGoogleMapsComposeTheme {


                val singapore = LatLng(1.35, 103.87)
                 val cameraPositionState = rememberCameraPositionState ()
               /* val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(singapore, 10f)
                }*/
                var uiSettings by remember { mutableStateOf(MapUiSettings()) }
                var properties by remember {
                    mutableStateOf(MapProperties(mapType = MapType.HYBRID))
                }
                Box(Modifier.fillMaxSize()) {
                    GoogleMap(
                        modifier = Modifier.matchParentSize(),
                       // properties = properties,
                        properties = MapProperties(isMyLocationEnabled = true),
                        uiSettings = uiSettings,
                        cameraPositionState = cameraPositionState
                    )


                    Column() {
                        Switch(
                            checked = uiSettings.zoomControlsEnabled,
                            onCheckedChange = {
                                uiSettings = uiSettings.copy(zoomControlsEnabled = it)
                            }
                        )

                        Button(onClick = {

                        }) {

                        }
                    }



                }

            }
        }
    }


}
