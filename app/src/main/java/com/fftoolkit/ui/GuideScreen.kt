package com.fftoolkit.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class Step(val t: String, val b: String)

@Composable
fun GuideScreen() {
    val steps = listOf(
        Step("1. Cài LSPatch", "github.com/LSPosed/LSPatch/releases → cài APK → mở → cấp quyền file."),
        Step("2. Patch FF", "LSPatch: Quản lý → + → APK đã cài → Free Fire → Local → 60s → Cài."),
        Step("3. Cài module", "App này → Công cụ → Cài module ESP → cài APK hiện ra."),
        Step("4. Bật module", "LSPatch: FF → Module → + → FF ESP Module → bật."),
        Step("5. Cấu hình", "App này → Cấu hình → bật ESP/aimbot/anti-ban."),
        Step("6. Chạy", "Mở FF bản patch → vào trận → box đỏ quanh địch.")
    )
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)) {
        Text("Hướng dẫn", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        steps.forEach { s ->
            Card(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Text(s.t, style = MaterialTheme.typography.titleMedium)
                    Text(s.b, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
        Spacer(Modifier.height(24.dp))
        Text("Test acc phụ trước. FF update → offset đổi.", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
    }
}
