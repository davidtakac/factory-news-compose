package hr.dtakac.factorynews.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.TypeConverters
import hr.dtakac.factorynews.UPDATE_TIMESTAMP_ID
import java.time.ZonedDateTime

@Dao
@TypeConverters(ZonedDateTimeConverter::class)
interface UpdateTimestampDao {
    @Query("UPDATE UpdateTimestamp SET updatedAt = :updatedAt WHERE id = $UPDATE_TIMESTAMP_ID")
    suspend fun update(updatedAt: ZonedDateTime)

    @Query("SELECT updatedAt FROM UpdateTimestamp WHERE id = $UPDATE_TIMESTAMP_ID")
    suspend fun get(): ZonedDateTime?
}