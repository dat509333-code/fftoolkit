package com.fftoolkit.core
import android.content.Context
import org.json.JSONObject
import java.io.File

class ConfigManager(ctx: Context) {
    private val f = File(ctx.filesDir, "ffesp_config.json")
    private var c = if (f.exists()) JSONObject(f.readText()) else JSONObject()
    var espEnabled: Boolean get() = c.optBoolean("esp_enabled", true) set(v) = put("esp_enabled", v)
    var espShowHp: Boolean get() = c.optBoolean("esp_show_hp", true) set(v) = put("esp_show_hp", v)
    var espShowDist: Boolean get() = c.optBoolean("esp_show_dist", true) set(v) = put("esp_show_dist", v)
    var aimbotEnabled: Boolean get() = c.optBoolean("aimbot_enabled", false) set(v) = put("aimbot_enabled", v)
    var aimbotFov: Float get() = c.optDouble("aimbot_fov", 15.0).toFloat() set(v) = put("aimbot_fov", v.toDouble())
    var aimbotSmoothMs: Float get() = c.optDouble("aimbot_smooth_ms", 125.0).toFloat() set(v) = put("aimbot_smooth_ms", v.toDouble())
    var aimbotJitter: Float get() = c.optDouble("aimbot_jitter", 0.5).toFloat() set(v) = put("aimbot_jitter", v.toDouble())
    var aimbotMissPct: Int get() = c.optInt("aimbot_miss_pct", 5) set(v) = put("aimbot_miss_pct", v)
    var antibanEnabled: Boolean get() = c.optBoolean("antiban_enabled", true) set(v) = put("antiban_enabled", v)
    private fun put(k: String, v: Any) { c.put(k, v); f.writeText(c.toString(2)) }
}
