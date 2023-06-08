package com.frame.kotlintoolkit.core

import android.content.Context
import android.content.SharedPreferences
import com.frame.kotlintoolkit.core.enums.Language
import com.orhanobut.hawk.Hawk

@Suppress("UNCHECKED_CAST")
class SharedPrefs(private val context: Context) {
    companion object {
        private const val PREF = "MedicoPrefs"
        private const val USER = "user"
        private const val LANGUAGE = "language"
    }

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)

    fun saveUser(token: String) {
        put(USER, token)
    }

    fun getUser(): String {
        return get(USER, String::class.java)
    }

    fun saveLanguage(language: Language) {
        put(LANGUAGE, language.value)
    }

    fun getLanguage(): Int {
        return get(LANGUAGE, Int::class.java)
    }

    private fun <T> get(key: String, clazz: Class<T>): T =
        when (clazz) {
            String::class.java -> Hawk.get(key, "")
            Boolean::class.java -> Hawk.get(key, false)
            Float::class.java -> Hawk.get(key, -1f)
            Double::class.java -> Hawk.get(key, -1f)
            Int::class.java -> Hawk.get(key, -1)
            Long::class.java -> Hawk.get(key, -1L)
            else -> null
        } as T

    private fun <T> put(key: String, data: T) {
        when (data) {
            is String -> Hawk.put(key, data)
            is Boolean -> Hawk.put(key, data)
            is Float -> Hawk.put(key, data)
            is Double -> Hawk.put(key, data.toFloat())
            is Int -> Hawk.put(key, data)
            is Long -> Hawk.put(key, data)
        }
    }

    fun clear() {
        sharedPref.edit().run {
            remove(USER)
        }.apply()
    }
}