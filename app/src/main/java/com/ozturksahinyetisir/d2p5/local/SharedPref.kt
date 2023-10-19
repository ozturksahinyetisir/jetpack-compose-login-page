package com.ozturksahinyetisir.d2p5.local
import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {
    private val sharedPrefs: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPrefs.edit()

    fun saveData(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun loadData(key: String): String {
        return sharedPrefs.getString(key, "") ?: ""
    }

    fun clearAllData() {
        editor.clear().apply()
    }
}