package com.fftoolkit.ui
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fftoolkit.core.ModuleInstaller

@Composable
fun ToolsScreen() {
    val ctx = LocalContext.current
    val pm = ctx.packageManager
    fun has(p: String) = try { pm.getPackageInfo(p, 0); true } catch (_: Exception) { false }
    Column(Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Công cụ", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        ToolCard(Icons.Default.Apps, "Mở LSPatch", if (has("org.lsposed.lspatch")) "Đã cài" else "Chưa cài", has("org.lsposed.lspatch")) {
            pm.getLaunchIntentForPackage("org.lsposed.lspatch")?.apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); ctx.startActivity(this) }
        }
        Spacer(Modifier.height(12.dp))
        ToolCard(Icons.Default.Gamepad, "Mở Free Fire", if (has("com.dts.freefireth")) "Đã cài" else "Chưa cài", has("com.dts.freefireth")) {
            pm.getLaunchIntentForPackage("com.dts.freefireth")?.apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); ctx.startActivity(this) }
        }
        Spacer(Modifier.height(12.dp))
        ToolCard(Icons.Default.Extension, "Cài module ESP", "Cài FF ESP Module", true) {
            ModuleInstaller(ctx).install()
        }
        Spacer(Modifier.height(12.dp))
        ToolCard(Icons.Default.Storage, "Trích .so", "Copy ra Download", true) {
            ModuleInstaller(ctx).extractSo()
        }
    }
}

@Composable
fun ToolCard(icon: ImageVector, title: String, sub: String, enabled: Boolean, onClick: () -> Unit) {
    Card(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null); Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(sub, style = MaterialTheme.typography.bodySmall)
            }
            Button(onClick = onClick, enabled = enabled) { Text("Chạy") }
        }
    }
}
