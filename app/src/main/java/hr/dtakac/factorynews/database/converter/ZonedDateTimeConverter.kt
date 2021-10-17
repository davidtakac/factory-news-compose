package hr.dtakac.factorynews.database.converter

import androidx.room.TypeConverter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object ZonedDateTimeConverter {
    private val formatter = DateTimeFormatter.ISO_DATE_TIME

    @JvmStatic
    @TypeConverter
    fun fromTimestamp(timestamp: String?): ZonedDateTime? {
        return timestamp?.let {
            ZonedDateTime.parse(it, formatter)
        }
    }

    @JvmStatic
    @TypeConverter
    fun toTimestamp(dateTime: ZonedDateTime?): String? {
        return dateTime?.format(formatter)
    }
}