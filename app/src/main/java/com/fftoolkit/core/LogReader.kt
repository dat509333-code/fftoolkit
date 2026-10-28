package com.fftoolkit.core
import java.io.BufferedReader
import java.io.InputStreamReader

class LogReader {
    fun read(): List<String> {
        val out = mutableListOf<String>()
        try {
            val p = Runtime.getRuntime().exec(arrayOf("logcat", "-d", "-s", "FFESP:V"))
            BufferedReader(InputStreamReader(p.inputStream)).use { r -> r.forEachLine { if (it.isNotBlank()) out.add(it) } }
            p.destroy()
        } catch (_: Exception) {}
        return out.takeLast(200)
    }
}
