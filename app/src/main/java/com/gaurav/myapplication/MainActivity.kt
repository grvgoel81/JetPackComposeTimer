package com.gaurav.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gaurav.myapplication.uitheme.MyTheme
import com.gaurav.myapplication.views.CountDownView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                TransparentStatusBar(windows = window)
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        CountDownView()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Composable
fun TransparentStatusBar(windows: Window) =
    MaterialTheme {

        windows.statusBarColor = MaterialTheme.colors.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colors.surface.toArgb()

        @Suppress("DEPRECATION")
        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        @Suppress("DEPRECATION")
        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
    }