package com.example.news_app.ui.db

import androidx.room.TypeConverter
import com.example.news_app.ui.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source?): String {
        return source?.name ?: "Unknown"
    }

    @TypeConverter
    fun toSource(name: String?): Source {
        return Source(name ?: "Unknown", name ?: "Unknown")
    }
}