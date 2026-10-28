package com.fftoolkit.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fftoolkit.core.ConfigManager

@Composable
fun ConfigScreen() {
    val ctx = LocalContext.current
    val c = remember { ConfigManager(ctx) }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)) {
        Text("Cấu hình", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Toggle("ESP bật", c.espEnabled) { c.espEnabled = it }
        Toggle("Hiện HP", c.espShowHp) { c.espShowHp = it }
        Toggle("Hiện khoảng cách", c.espShowDist) { c.espShowDist = it }
        Spacer(Modifier.height(16.dp))
        Toggle("Aimbot", c.aimbotEnabled) { c.aimbotEnabled = it }
        Slider("FOV", c.aimbotFov, 5f, 60f) { c.aimbotFov = it }
        Slider("Smooth ms", c.aimbotSmoothMs, 50f, 300f) { c.aimbotSmoothMs = it }
        Slider("Jitter °", c.aimbotJitter, 0f, 3f) { c.aimbotJitter = it }
        Spacer(Modifier.height(16.dp))
        Toggle("Anti-ban 5 tầng", c.antibanEnabled) { c.antibanEnabled = it }
    }
}
@Composable private fun Toggle(l: String, v: Boolean, on: (Boolean) -> Unit) {
    Row(Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(l, Modifier.weight(1f)); Switch(v, on)
    }
}
@Composable private fun Slider(l: String, v: Float, min: Float, max: Float, on: (Float) -> Unit) {
    Column(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Text("$l: ${"%.1f".format(v)}", style = MaterialTheme.typography.bodyMedium)
        Slider(v, on, valueRange = min..max)
    }
}
