package hr.dtakac.factorynews.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import hr.dtakac.factorynews.UPDATE_TIMESTAMP_ID
import hr.dtakac.factorynews.database.converter.ZonedDateTimeConverter
import java.time.ZonedDateTime

@Entity
@TypeConverters(ZonedDateTimeConverter::class)
data class UpdateTimestamp(
    @PrimaryKey
    val id: Int = UPDATE_TIMESTAMP_ID,
    val updatedAt: ZonedDateTime
)