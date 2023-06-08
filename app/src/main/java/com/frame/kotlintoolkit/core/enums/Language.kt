package com.frame.kotlintoolkit.core.enums

enum class Language(val value: Int) {
    ENGLISH(0),
    HINDI(1),
    INDONESIA(2);

    companion object {
        private val types = values().associateBy { it.value }
        fun findByValue(value: Int) = types[value]
    }
}