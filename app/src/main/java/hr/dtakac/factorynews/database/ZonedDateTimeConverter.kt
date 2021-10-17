package hr.dtakac.factorynews.database

import androidx.room.TypeConverter
import java.time.ZonedDateTime

object ZonedDateTimeConverter {
    @JvmStatic
    @TypeConverter
    fun fromTimestamp(timestamp: String?): ZonedDateTime? {
        return timestamp?.let {
            try {
                ZonedDateTime.parse(it)
            } catch (e: Exception) {
                null
            }
        }
    }

    @JvmStatic
    @TypeConverter
    fun toTimestamp(dateTime: ZonedDateTime?): String? {
        return try {
            dateTime?.toString()
        } catch (e: Exception) {
            null
        }
    }
}