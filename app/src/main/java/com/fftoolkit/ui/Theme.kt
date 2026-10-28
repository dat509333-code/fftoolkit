package com.fftoolkit.ui
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme())
            darkColorScheme(primary = Color(0xFFFF5252), surface = Color(0xFF101010))
        else lightColorScheme(primary = Color(0xFFD32F2F)),
        content = content
    )
}
