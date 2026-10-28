package com.fftoolkit.core
import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

class ModuleInstaller(private val ctx: Context) {
    fun install() = launch(extract("module.apk"), "application/vnd.android.package-archive")
    fun extractSo() {
        val so = extract("libffesp.so")
        try { so.copyTo(File("/sdcard/Download/libffesp.so"), true) } catch (_: Exception) {}
    }
    private fun extract(name: String): File {
        val f = File(ctx.cacheDir, name)
        if (f.exists() && f.length() > 0) return f
        ctx.assets.open(name).use { i -> FileOutputStream(f).use { o -> i.copyTo(o) } }
        return f
    }
    private fun launch(file: File, mime: String) {
        val uri = FileProvider.getUriForFile(ctx, "${ctx.packageName}.fileprovider", file)
        ctx.startActivity(Intent(Intent.ACTION_VIEW).apply { setDataAndType(uri, mime); addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK) })
    }
}
