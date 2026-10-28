package com.fftoolkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.fftoolkit.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        setContent { Theme { App() } }
    }
}

data class TabItem(val label: String, val icon: ImageVector)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var tab by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        TabItem("Hướng dẫn", Icons.Default.Info),
        TabItem("Công cụ", Icons.Default.Build),
        TabItem("Cấu hình", Icons.Default.Settings),
        TabItem("Log", Icons.Default.List)
    )
    Scaffold(
        topBar = { TopAppBar(title = { Text("FF Toolkit") }) },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { i, t ->
                    NavigationBarItem(
                        selected = tab == i, onClick = { tab = i },
                        icon = { Icon(t.icon, t.label) },
                        label = { Text(t.label) }
                    )
                }
            }
        }
    ) { p ->
        Box(Modifier.padding(p).fillMaxSize()) {
            when (tab) {
                0 -> GuideScreen()
                1 -> ToolsScreen()
                2 -> ConfigScreen()
                3 -> LogScreen()
            }
        }
    }
}
